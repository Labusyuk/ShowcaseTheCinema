package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.Movies;
import com.labus.mycinema.entity.Timetable;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimetableDao extends EntityDao {
    private final static String SELECT_ALL = "SELECT timetable.SeansID, timetable.Time, timetable.Movie_id, movies.Name, movies.AgeLimit, movies.Dimension, timetable.Price, timetable.Visible FROM timetable JOIN movies ON timetable.Movie_Id = movies.Id";

    public List<Timetable> getTimeTable() throws DaoException{
        List<Timetable> timetables = new ArrayList<>();
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timetable timetable = retrieveEntity(resultSet);
                timetables.add(timetable);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        timetables.sort((o1,o2)->o1.getTime().compareTo(o2.getTime()));
        return timetables;
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
