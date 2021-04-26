package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;
import com.peregud.pizza.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositorySQLImpl implements OrderRepository {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;

    static {
        SQL_SAVE = "INSERT INTO orders.pizzas(pizza, price, order_time) " + "VALUE (?, ?, ?);";
        SQL_GET = "SELECT * FROM orders.pizzas";
    }

    @Override
    public void save(List<Order> list) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            for (Order order : list) {
                preparedStmt.setString(1, order.getPizza());
                preparedStmt.setDouble(2, order.getPrice());
                preparedStmt.setString(3, order.getOrderTime());
                preparedStmt.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void save(Order order) throws SQLException {

    }

    @Override
    public Order get(Serializable id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public List<Order> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET);
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
                ConnectorUtil.closeConnection();
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
