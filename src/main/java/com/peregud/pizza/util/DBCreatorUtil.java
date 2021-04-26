package com.peregud.pizza.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBCreatorUtil {

    private DBCreatorUtil() {
    }

    public static void createPizzaDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "CREATE SCHEMA IF NOT EXISTS `Orders`";
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

    public static void createEmployeeAddressDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DROP SCHEMA IF EXISTS `EmployeeDB`";
            String sql2 = "CREATE SCHEMA IF NOT EXISTS `EmployeeDB` DEFAULT CHARACTER SET utf8";
            String sql3 = "DROP TABLE IF EXISTS `EmployeeDB`.`Employee`";
            String sql4 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Employee`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`     VARCHAR(20)     NULL,\n" +
                    "  `last_name`      VARCHAR(20)     NULL,\n" +
                    "  `salary`         DEC             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String sql5 = "DROP TABLE IF EXISTS `EmployeeDB`.`Address`";
            String sql6 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `street`         VARCHAR(20)     NULL,\n" +
                    "  `house`          INT             NULL,\n" +
                    "  `apartment`      INT             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String sql7 = "DROP TABLE IF EXISTS `EmployeeDB`.`Employee_Address`";
            String sql8 = "CREATE TABLE IF NOT EXISTS `EmployeeDB`.`Employee_Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `employee_id`    INT             NOT NULL,\n" +
                    "  `address_id`     INT             NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_employee_address_idx` (`address_id` ASC) VISIBLE,\n" +
                    "  INDEX `fk_address_employee_idx` (`employee_id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `fk_employee_address`\n" +
                    "  FOREIGN KEY (`employee_id`)\n" +
                    "  REFERENCES `EmployeeDB`.`Employee` (`id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_address_employee`\n" +
                    "  FOREIGN KEY (`address_id`)\n" +
                    "  REFERENCES `PeopleDB`.`Employee` (`id`)\n" +
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
}
