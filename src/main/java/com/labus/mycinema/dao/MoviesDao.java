package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao extends EntityDao <Integer, Movies>{
    private final static String SELECT_BY_ID = "SELECT MovieId, Name, Description, Price, Duration, Genre, AgeLimit, Dimension, Production, GraduationYear, Producer, Scenario, Staring FROM cinemadb.movies WHERE MovieId=?";
    private final static String SELECT_ALL = "SELECT MovieId, Name, Description, Price, Duration, Genre, AgeLimit, Dimension, Production, GraduationYear, Producer, Scenario, Staring FROM cinemadb.movies";
    private final static String INSERT_MOVIE = "INSERT INTO cinemadb.movies(Name, Description, Price, Duration, Genre, AgeLimit, Dimension, Production, GraduationYear, Producer, Scenario, Staring) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String UPDATE_MOVIE = "UPDATE cinemadb.movies SET Price=?, AgeLimit=?, Dimension=? WHERE MovieId=?"  ;
    private final static String DELETE_MOVIE = "DELETE FROM cinemadb.movies WHERE MovieId=?";

    @Override
    public List<Movies> findAll() throws DaoException{
        List<Movies> movies = new ArrayList<>();
        try (
                Connection connection = pool.takeConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Movies movie = retrieveEntity(resultSet);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return movies;
    }

    @Override
    public Movies find(Integer id) throws DaoException{
        Movies movies = null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                movies = retrieveEntity(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return movies;
    }

    @Override
    public Integer create(Movies entity) throws DaoException {
        int idMovies = 0;
        try(Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1,entity.getId());
            statement.setString(2,entity.getName());
            statement.setString(3,entity.getDescription());
            statement.setInt(4,entity.getPrice());
            statement.setTime(5,entity.getDuration());
            statement.setString(6,entity.getGenre());
            statement.setInt(7,entity.getAgelimit());
            statement.setString(8,entity.getDimension());
            statement.setString(9,entity.getProduction());
            statement.setDate(10,entity.getGraduationYear());
            statement.setString(11,entity.getProducer());
            statement.setString(12,entity.getScenario());
            statement.setString(13,entity.getStaring());
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                idMovies = generatedKey.getInt(1);
            }
            generatedKey.close();
        }catch (SQLException e){
            throw new DaoException();
        }
        return idMovies;
    }

    @Override
    public void update(Movies movies) throws DaoException {
        try(Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIE)){
            statement.setInt(1, movies.getPrice());
            statement.setInt(2, movies.getAgelimit());
            statement.setString(3,movies.getDimension());
            statement.setInt(4,movies.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            new DaoException();
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try(Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            new DaoException();
        }
    }

    public Movies retrieveEntity(ResultSet resultSet) throws DaoException{
        Movies movies = new Movies();
        try{
            movies.setId(resultSet.getInt("Id"));
            movies.setName(resultSet.getString("Name"));
            movies.setDescription(resultSet.getString("Description"));
            movies.setPrice(resultSet.getInt("Price"));
            movies.setDuration(resultSet.getTime("Duration"));
            movies.setGenre(resultSet.getString("Genre"));
            movies.setAgelimit(resultSet.getInt("AgeLimit"));
            movies.setDimension(resultSet.getString("Dimension"));
            movies.setProduction(resultSet.getString("Production"));
            movies.setGraduationYear(resultSet.getDate("GraduationYear"));
            movies.setProducer(resultSet.getString("Producer"));
            movies.setScenario(resultSet.getString("Scenario"));
            movies.setStaring(resultSet.getString("Staring"));
        } catch (SQLException e) {
            throw new DaoException();
        }
        return movies;
    }

}
