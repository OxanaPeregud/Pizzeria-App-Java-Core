/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

@UtilityClass
public class ConnectorUtil {
    private Connection conn;
    private final String SQL_URL = "url";
    private final String USER = "login";
    private final String PASSWORD = "password";
    private final String DATABASE_DRIVER_NAME = "driverName";
    private final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("database");

    public Connection getConnection() throws SQLException {
        loadDriver();
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(getProperty(SQL_URL), getProperty(USER), getProperty(PASSWORD));
        }
        return conn;
    }

    public Connection closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        return null;
    }

    public void loadDriver() {
        try {
            Class.forName(getProperty(DATABASE_DRIVER_NAME));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    public String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
