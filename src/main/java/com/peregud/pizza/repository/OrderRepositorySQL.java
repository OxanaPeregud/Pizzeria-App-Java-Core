package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositorySQL implements OrderRepository {
    private static final String SQL_URL;

    static {
        SQL_URL = "jdbc:mysql://localhost:3306/orders";
    }

    @Override
    public void orderInput(List<Order> list) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            String sql = "insert into orders.pizzas(pizza, price, order_time) " + "VALUE (?, ?, ?);";
            preparedStatement = conn.prepareStatement(sql);
            for (Order order : list) {
                preparedStatement.setString(1, order.getPizza());
                preparedStatement.setDouble(2, order.getPrice());
                preparedStatement.setString(3, order.getOrderTime());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Order> orderOutput() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from orders.pizzas");
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setPizza(rs.getString("pizza"));
                order.setPrice(rs.getDouble("price"));
                order.setOrderTime(rs.getString("order_time"));
                list.add(order);
            }
            return list;
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
        return null;
    }
}
