package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;

import java.sql.*;
import java.util.List;

public class UserDao extends EntityDao<Integer, User>{
    private final static String SELECT_BY_LOG_AND_PASS = "SELECT Login, Password, Role, FirstName, SecondName, Phone, Email FROM cinemadb.users WHERE Login=? AND Password=?";
    private final static String SELECT_BY_DUPLICATION = "SELECT Login, Phone, Email FROM cinemadb.users WHERE Login=? OR Phone=? OR Email=?";
    private final static String INSERT_USER = "INSERT INTO cinemadb.users (Login, Password, Role, FirstName, SecondName, Phone, Email, Cash) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    //private final static String SELECT_ALL = "SELECT Login, Password, Role, FirstName, SecondName, Phone, Email FROM bankschema.users";
    private final static String UPDATE_BY_LOGIN = "UPDATE cinemadb.users SET FirstName=?, SecondName=? WHERE Login=?";
    private final static String SELECT_BY_ID = "SELECT UserId, Login, Password, Role, FirstName, SecondName, Phone, Email FROM cinemadb.users WHERE UserId=?";


    public User getByLogAndPass(String login, String password) throws DaoException{
        User user = null;
        try (Connection connection = pool.takeConnection();PreparedStatement statement = connection.prepareStatement(SELECT_BY_LOG_AND_PASS)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = retrieveEntity(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    public User retrieveEntity(ResultSet resultSet) throws DaoException{
        User user = new User();
        try{
            user.setLogin(resultSet.getString("Login"));
            user.setPassword(resultSet.getString("Password"));
            user.setRole(UserRole.valueOf(resultSet.getString("Role").toUpperCase()));
            user.setFirstName(resultSet.getString("FirstName"));
            user.setSecondName(resultSet.getString("SecondName"));
            user.setPhone(resultSet.getString("Phone"));
            user.setEmail(resultSet.getString("Email"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    public boolean isRegistered(User user) throws DaoException {
        boolean isRegistered = false;
        try (Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BY_DUPLICATION)) {
            statement.setString(1, user.getLogin());
            statement.setString(2,user.getPhone());
            statement.setString(3,user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isRegistered = true;
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRegistered;
    }

    @Override
    public Integer create(User user) throws DaoException {
        int idUser = 0;
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, String.valueOf(user.getRole()));
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getSecondName());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getEmail());
            statement.setInt(8,11191);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next())
                idUser = resultSet.getInt(1);
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return idUser;
    }

    @Override
    public User find(Integer id) throws DaoException {
        User user = null;
        try(Connection connection = pool.takeConnection();PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                user = retrieveEntity(resultSet);
        }catch (SQLException e){
            throw new DaoException();
        }
        return user;
    }

    @Override
    public List<User> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer attribute) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User user) throws DaoException {
        try(Connection connection = pool.takeConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BY_LOGIN)){
            statement.setString(1, user.getFirstName());
            statement.setString(2,user.getSecondName());
            statement.setString(3,user.getLogin());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException();
        }
    }
}
