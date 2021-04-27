package com.peregud.pizza.repository;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    void save(List<T> t) throws SQLException;

    void save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(Serializable id) throws SQLException;

    List<T> getAll() throws SQLException;

}
