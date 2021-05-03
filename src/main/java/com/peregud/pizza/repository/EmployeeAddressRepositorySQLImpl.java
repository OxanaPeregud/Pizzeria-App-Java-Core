/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.repository;

import com.peregud.pizza.model.EmployeeAddress;
import com.peregud.pizza.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAddressRepositorySQLImpl implements EmployeeAddressRepository {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET_ALL;

    static {
        SQL_SAVE = "INSERT INTO employeeDB.employee_address(employee_id, address_id) " + "VALUE (?, ?)";
        SQL_GET = "SELECT * FROM employeeDB.employee_address WHERE employee_id = ";
        SQL_UPDATE = "UPDATE employeeDB.employee_address SET address_id = ? WHERE employee_id = ?";
        SQL_DELETE = "DELETE FROM employeeDB.employee_address WHERE employee_id = ";
        SQL_GET_ALL = "SELECT * FROM employeeDB.employee_address";
    }

    @Override
    public void save(List<EmployeeAddress> list) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            for (EmployeeAddress employeeAddress : list) {
                preparedStmt.setInt(1, employeeAddress.getEmployeeID());
                preparedStmt.setInt(2, employeeAddress.getAddressID());
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
    public void save(EmployeeAddress employeeAddress) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, employeeAddress.getEmployeeID());
            preparedStmt.setInt(2, employeeAddress.getAddressID());
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
    public EmployeeAddress get(Serializable id) {
        EmployeeAddress employeeAddress = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                employeeAddress = new EmployeeAddress();
                employeeAddress.setEmployeeID(rs.getInt("employee_id"));
                employeeAddress.setAddressID(rs.getInt("address_id"));
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
        return employeeAddress;
    }

    @Override
    public void update(EmployeeAddress employeeAddress) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
            preparedStmt.setInt(1, employeeAddress.getAddressID());
            preparedStmt.setInt(2, employeeAddress.getEmployeeID());
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
    public List<EmployeeAddress> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<EmployeeAddress> list = new ArrayList<>();
            while (rs.next()) {
                EmployeeAddress employeeAddress = new EmployeeAddress();
                employeeAddress.setEmployeeID(rs.getInt("employee_id"));
                employeeAddress.setAddressID(rs.getInt("address_id"));
                list.add(employeeAddress);
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
