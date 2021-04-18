package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderRepositorySQL implements OrderRepository {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/orders";

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
}
