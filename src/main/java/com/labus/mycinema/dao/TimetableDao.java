package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.Timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimetableDao extends EntityDao<Integer, Timetable> {
    private final static String SELECT_ALL = "SELECT SeansID, Time, Movie_id, cinemadb.movies.Name, cinemadb.movies.AgeLimit, cinemadb.movies.Dimension, Price, Visible FROM cinemadb.timetable JOIN movies ON Movie_Id = movies.MovieId";
    private final static String SELECT_BY_ID = "SELECT SeansID, Time, Movie_id, cinemadb.movies.Name, cinemadb.movies.AgeLimit, cinemadb.movies.Dimension, Price, Visible FROM cinemadb.timetable WHERE SeansID=?";
    private final static String INSERT_TIMETABLE = "INSERT INTO cinemadb.timetable(Time, Movie_id, cinemadb.movies.Name, cinemadb.movies.AgeLimit, cinemadb.movies.Dimension, Price, Visible) VALUES (?,?,?,?,?,?,?)";
    private final static String DELETE_TIMETABLE = "DELETE FROM cinemadb.timetable WHERE SeansID=?";
    private final static String UPDATE_TIMETABLE = "UPDATE cinemadb.timetable SET Price=?, Time=? WHERE SeansId=?";

    public List<Timetable> findAll() throws DaoException{
        List<Timetable> timetables = new ArrayList<>();
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timetable timetable = retrieveEntity(resultSet);
                timetables.add(timetable);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        timetables.sort(Comparator.comparing(Timetable::getTime));
        return timetables;
    }

    public Timetable find(Integer seansId) throws DaoException{
        Timetable timetable = null;
        try(Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)){
            statement.setString(1, "");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                timetable = retrieveEntity(resultSet);
            resultSet.close();
        }catch (SQLException e){
            throw new DaoException();
        }
        return timetable;
    }

    @Override
    public Integer create(Timetable timetable) throws DaoException {
        int idTimetable = 0;
        try (Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_TIMETABLE, PreparedStatement.RETURN_GENERATED_KEYS)){
            statement.setInt(1,timetable.getId());
            statement.setTimestamp(2,timetable.getTime());
            statement.setInt(3,timetable.getMovieId());
            statement.setInt(4,timetable.getPrice());
            statement.setShort(5,timetable.getVisible());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                idTimetable = resultSet.getInt(1);
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return idTimetable;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try (Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TIMETABLE)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException();
        }
    }

    @Override
    public void update(Timetable entity) throws DaoException {
            try(Connection connection = pool.takeConnection();PreparedStatement statement = connection.prepareStatement(UPDATE_TIMETABLE)){
                statement.setInt(1,entity.getPrice());
                statement.setTimestamp(2,entity.getTime());
                statement.setInt(3,entity.getId());
                statement.executeUpdate();
            }catch (SQLException e){
                throw new DaoException();
            }
    }

    private Timetable retrieveEntity(ResultSet resultSet) throws DaoException {
        Timetable timetable = new Timetable();
        try{
            timetable.setId(resultSet.getInt("SeansId"));
            timetable.setTime(resultSet.getTimestamp("Time"));
            timetable.setMovieId(resultSet.getInt("Movie_id"));
            timetable.setMovieName(resultSet.getString("Name"));
            timetable.setAgeLimit(resultSet.getInt("AgeLimit"));
            timetable.setDimension(resultSet.getString("Dimension"));
            timetable.setPrice(resultSet.getInt("Price"));
            timetable.setVisible(resultSet.getShort("Visible"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return timetable;
    }
}
