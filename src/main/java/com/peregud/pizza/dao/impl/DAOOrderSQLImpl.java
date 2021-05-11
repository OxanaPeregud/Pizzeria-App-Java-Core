/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.impl;

import com.peregud.pizza.dao.DAOOrder;
import com.peregud.pizza.model.Order;
import com.peregud.pizza.dao.util.ConnectorUtil;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DAOOrderSQLImpl implements DAOOrder {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_GET_ALL;
    private DataSource dataSource;

    static {
        SQL_SAVE = "INSERT INTO orders.pizzas(order_id, pizza, price, order_time) " + "VALUE (?, ?, ?, ?);";
        SQL_GET = "SELECT * FROM orders.pizzas WHERE order_id = ";
        SQL_GET_ALL = "SELECT * FROM orders.pizzas";
    }

    public DAOOrderSQLImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(List<Order> list) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            for (Order order : list) {
                preparedStmt.setInt(1, order.getId());
                preparedStmt.setString(2, order.getPizza());
                preparedStmt.setDouble(3, order.getPrice());
                preparedStmt.setString(4, order.getOrderTime());
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
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, order.getId());
            preparedStmt.setString(2, order.getPizza());
            preparedStmt.setDouble(3, order.getPrice());
            preparedStmt.setString(4, order.getOrderTime());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Order get(Serializable id) {
        Order order = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("order_id"));
                order.setPizza(rs.getString("pizza"));
                order.setPrice(rs.getDouble("price"));
                order.setOrderTime(rs.getString("order_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
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
        return order;
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
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("order_id"));
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
