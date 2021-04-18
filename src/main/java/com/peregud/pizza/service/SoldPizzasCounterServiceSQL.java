package com.peregud.pizza.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoldPizzasCounterServiceSQL implements SoldPizzasCounterService {
    private static final String SQL_URL;

    static {
        SQL_URL = "jdbc:mysql://localhost:3306/orders";
    }

    public List<String> countPizzasFourCheese() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders.pizzas WHERE pizza = 'FOUR_CHEESE'");
            while (rs.next()) {
                String str = rs.getString("price");
                list.add(str);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public List<String> countPizzasMargherita() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders.pizzas WHERE pizza = 'MARGHERITA'");
            while (rs.next()) {
                String str = rs.getString("price");
                list.add(str);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public List<String> countPizzasMeatDelight() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders.pizzas WHERE pizza = 'MEAT_DELIGHT'");
            while (rs.next()) {
                String str = rs.getString("price");
                list.add(str);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public List<String> countPizzasPepperoni() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders.pizzas WHERE pizza = 'PEPPERONI'");
            while (rs.next()) {
                String str = rs.getString("price");
                list.add(str);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    public List<String> countPizzasVegetarian() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders.pizzas WHERE pizza = 'VEGETARIAN'");
            while (rs.next()) {
                String str = rs.getString("price");
                list.add(str);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
