package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.Movies;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao extends EntityDao{
    private final static String SELECT_BY_ID = "SELECT Id, Name, Description, Price, Duration, Genre, AgeLimit, Dimension, Production, GraduationYear, Producer, Scenario, Staring FROM cinemadb.movies WHERE Id=?";
    private final static String SELECT_ALL = "SELECT Id, Name, Description, Price, Duration, Genre, AgeLimit, Dimension, Production, GraduationYear, Producer, Scenario, Staring FROM cinemadb.movies";


    public List<Movies> getAll() throws DaoException{
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
            throw new DaoException(e);
        }
        return movies;
    }

    public Movies getById(Integer id) throws DaoException{
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
            throw new DaoException(e);
        }
        return movies;
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
            throw new DaoException(e);
        }
        return movies;
    }

}
