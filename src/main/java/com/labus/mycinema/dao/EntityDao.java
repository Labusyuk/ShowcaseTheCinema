package com.labus.mycinema.dao;

import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.db.ConnectionPool;
import com.labus.mycinema.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityDao <K, T extends Entity>{
    protected ConnectionPool pool = ConnectionPool.getInstance();
    public abstract K create(T entity) throws DaoException;
    public abstract T find(K attribute) throws DaoException;
    public abstract List<T> findAll() throws DaoException;
    public abstract void delete(K attribute) throws DaoException;
    public abstract void update(T entity) throws DaoException;
}
