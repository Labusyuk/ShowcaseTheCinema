package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.db.ConnectionPool;
import com.labus.mycinema.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityDao{
    ConnectionPool pool = ConnectionPool.getInstance();
    protected Connection connection = null;
    EntityDao() {
    }
    public void takeConnection(){
        try {
            connection = pool.takeConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnConnection(Connection connection) {
        pool.returnConnection(connection);
    }
}
