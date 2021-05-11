/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.impl;

import com.peregud.pizza.dao.DAOCustomer;
import com.peregud.pizza.model.Customer;
import com.peregud.pizza.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomerSQLImpl implements DAOCustomer {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET_ALL;

    static {
        SQL_SAVE = "INSERT INTO customerDB.customer(customer_id, first_name, last_name, card_number, order_id) " +
                "VALUE (?, ?, ?, ?, ?)";
        SQL_GET = "SELECT * FROM customerDB.customer WHERE customer_id = ";
        SQL_UPDATE = "UPDATE customerDB.customer SET card_number = ? WHERE customer_id = ?";
        SQL_DELETE = "DELETE FROM customerDB.customer WHERE customer_id = ";
        SQL_GET_ALL = "SELECT * FROM customerDB.customer";
    }

    @Override
    public void save(List<Customer> list) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            for (Customer customer : list) {
                preparedStmt.setString(1, customer.getFirstName());
                preparedStmt.setString(2, customer.getLastName());
                preparedStmt.setString(3, customer.getCardNumber());
                preparedStmt.setInt(4, customer.getOrderID());
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
    public void save(Customer customer) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, customer.getId());
            preparedStmt.setString(2, customer.getFirstName());
            preparedStmt.setString(3, customer.getLastName());
            preparedStmt.setString(4, customer.getCardNumber());
            preparedStmt.setInt(5, customer.getOrderID());
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
    public Customer get(Serializable id) {
        Customer customer = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setCardNumber(rs.getString("card_number"));
                customer.setOrderID(rs.getInt("order_id"));
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
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
            preparedStmt.setString(1, customer.getCardNumber());
            preparedStmt.setInt(2, customer.getId());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Serializable id) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(SQL_DELETE + id);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Customer> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setCardNumber(rs.getString("card_number"));
                list.add(customer);
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
