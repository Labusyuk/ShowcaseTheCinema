package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends EntityDao{
    private final static String SELECT_BY_LOG_AND_PASS = "SELECT Login, Password, Role, FirstName, SecondName, Phone, Email FROM cinemadb.users WHERE Login=? AND Password=?";
    private final static String INSERT_USER = "INSERT INTO cinemadb.users (Login, Password, Role, FirstName, SecondName, Phone, Email) VALUES (?, ?, ?, ?, ?)";
    //private final static String SELECT_ALL = "SELECT Login, Password, Role, FirstName, SecondName, Phone, Email FROM bankschema.users";
    private final static String UPDATE_BY_LOGIN = "UPDATE cinemadb.users SET Password=?, Role=?, FirstName=?, SecondName=? WHERE Login=?";
    private final static String SELECT_BY_EMAIL = "SELECT Login, Password, Role, FirstName, SecondName, Phone, Email FROM cinemadb.users WHERE Email=?";



    public User getByLogAndPass(String login, String password){
        takeConnection();
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_LOG_AND_PASS)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = retrieveEntity(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            returnConnection(connection);
        }
        return user;
    }

    public User retrieveEntity(ResultSet resultSet){
        User user = new User();
        try{
            user.setLogin(resultSet.getString("Login"));
            user.setPassword(resultSet.getString("Password"));
            user.setRole(UserRole.valueOf(resultSet.getString("Role")));
            user.setFirstName(resultSet.getString("FirstName"));
            user.setSecondName(resultSet.getString("SecondName"));
            user.setPhone(resultSet.getString("Phone"));
            user.setEmail(resultSet.getString("Email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean isRegistered(String email) throws DaoException {
        boolean isRegistered = true;
        takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                isRegistered = false;
            }
            resultSet.close();
        } catch (SQLException e) {
        }
        return isRegistered;
    }

}
