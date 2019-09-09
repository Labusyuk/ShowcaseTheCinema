package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.db.ConnectionPool;
import com.labus.mycinema.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityDao{
    protected ConnectionPool pool = ConnectionPool.getInstance();
    EntityDao() {
    }
}
