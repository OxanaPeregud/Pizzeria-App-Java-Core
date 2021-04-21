package com.peregud.pizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePizzasDatabaseUtil {

    private CreatePizzasDatabaseUtil() {
    }

    public static void createDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "CREATE SCHEMA IF NOT EXISTS `Orders` DEFAULT CHARACTER SET utf8;";
            String sql2 = "CREATE TABLE IF NOT EXISTS `Orders`.`Pizzas`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `pizza`          VARCHAR(20)     NULL,\n" +
                    "  `price`          DECIMAL         NULL,\n" +
                    "  `order_time`     CHAR(19)        NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
