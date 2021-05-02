package com.peregud.pizza.repository;

import com.peregud.pizza.model.Address;
import com.peregud.pizza.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepositorySQLImpl implements AddressRepository {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET_ALL;

    static {
        SQL_SAVE = "INSERT INTO employeeDB.address(address_id, street, house, apartment) " + "VALUE (?, ?, ?, ?)";
        SQL_GET = "SELECT * FROM employeeDB.address WHERE address_id = ";
        SQL_UPDATE = "UPDATE employeeDB.address SET street = ?, apartment = ?, house = ? WHERE address_id = ?";
        SQL_DELETE = "DELETE FROM employeeDB.address WHERE address_id = ";
        SQL_GET_ALL = "SELECT * FROM employeeDB.address";
    }

    @Override
    public void save(List<Address> list) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            for (Address address : list) {
                preparedStmt.setInt(1, address.getId());
                preparedStmt.setString(2, address.getStreet());
                preparedStmt.setInt(3, address.getHouse());
                preparedStmt.setInt(4, address.getApartment());
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
    public void save(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, address.getId());
            preparedStmt.setString(2, address.getStreet());
            preparedStmt.setInt(3, address.getHouse());
            preparedStmt.setInt(4, address.getApartment());
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
    public Address get(Serializable id) {
        Address address = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                address = new Address();
                address.setId(rs.getInt("address_id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                address.setApartment(rs.getInt("apartment"));
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
        return address;
    }

    @Override
    public void update(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
            preparedStmt.setString(1, address.getStreet());
            preparedStmt.setInt(2, address.getHouse());
            preparedStmt.setInt(3, address.getApartment());
            preparedStmt.setInt(4, address.getId());
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
    public List<Address> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<Address> list = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("address_id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                address.setApartment(rs.getInt("apartment"));
                list.add(address);
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
