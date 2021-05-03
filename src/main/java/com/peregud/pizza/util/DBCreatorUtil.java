/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DBCreatorUtil {

    public static void createPizzaDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DROP SCHEMA IF EXISTS `Orders`";
            String sql2 = "CREATE SCHEMA IF NOT EXISTS `Orders`";
            String sql3 = "DROP TABLE IF EXISTS `Orders`.`Pizzas`";
            String sql4 = "CREATE TABLE IF NOT EXISTS `Orders`.`Pizzas`\n" +
                    "(\n" +
                    "  `order_id`       INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `pizza`          VARCHAR(20)     NULL,\n" +
                    "  `price`          DECIMAL         NULL,\n" +
                    "  `order_time`     CHAR(19)        NULL,\n" +
                    "  PRIMARY KEY (`order_id`)\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
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

    public static void createEmployeeAddressDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DROP SCHEMA IF EXISTS `EmployeeDB`";
            String sql2 = "CREATE SCHEMA IF NOT EXISTS `EmployeeDB`";
            String sql3 = "DROP TABLE IF EXISTS `EmployeeDB`.`Employee`";
            String sql4 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Employee`\n" +
                    "(\n" +
                    "  `employee_id`    INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`     VARCHAR(20)     NULL,\n" +
                    "  `last_name`      VARCHAR(20)     NULL,\n" +
                    "  `salary`         DEC             NULL,\n" +
                    "  PRIMARY KEY (`employee_id`)\n" +
                    ");";
            String sql5 = "DROP TABLE IF EXISTS `EmployeeDB`.`Address`";
            String sql6 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Address`\n" +
                    "(\n" +
                    "  `address_id`     INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `street`         VARCHAR(20)     NULL,\n" +
                    "  `house`          INT             NULL,\n" +
                    "  `apartment`      INT             NULL,\n" +
                    "  PRIMARY KEY (`address_id`)\n" +
                    ");";
            String sql7 = "DROP TABLE IF EXISTS `EmployeeDB`.`Employee_Address`";
            String sql8 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Employee_Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `employee_id`    INT             NOT NULL,\n" +
                    "  `address_id`     INT             NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  FOREIGN KEY (`employee_id`)\n" +
                    "  REFERENCES `EmployeeDB`.`Employee` (`employee_id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE,\n" +
                    "  FOREIGN KEY (`address_id`)\n" +
                    "  REFERENCES `PeopleDB`.`Address` (`address_id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);
            stmt.executeUpdate(sql7);
            stmt.executeUpdate(sql8);
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

    public static void createCustomerDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DROP SCHEMA IF EXISTS `CustomerDB`";
            String sql2 = "CREATE SCHEMA IF NOT EXISTS `CustomerDB`";
            String sql3 = "DROP TABLE IF EXISTS `CustomerDB`.`Customer`";
            String sql4 = "CREATE TABLE IF NOT EXISTS `CustomerDB`.`Customer`\n" +
                    "(\n" +
                    "  `customer_id`    INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`     VARCHAR(20)     NULL,\n" +
                    "  `last_name`      VARCHAR(20)     NULL,\n" +
                    "  `card_number`    VARCHAR(16)     NULL,\n" +
                    "  `order_id`       INT             NULL,\n" +
                    "  PRIMARY KEY (`customer_id`),\n" +
                    "  FOREIGN KEY (`order_id`)\n" +
                    "  REFERENCES `Orders`.`Pizzas` (`order_id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
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
