package com.peregud.pizza.repository;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    void save(List<T> t) throws SQLException;

    List<T> getAll() throws SQLException;

}
