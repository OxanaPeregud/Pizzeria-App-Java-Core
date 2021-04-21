package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;
import com.peregud.pizza.util.ConnectorUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderSQLImpl implements OrderRepository {

    @Override
    public void orderInput(List<Order> list) {
        PreparedStatement prst = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sql = "insert into orders.pizzas(pizza, price, order_time) " + "VALUE (?, ?, ?);";
            prst = conn.prepareStatement(sql);
            for (Order order : list) {
                prst.setString(1, order.getPizza());
                prst.setDouble(2, order.getPrice());
                prst.setString(3, order.getOrderTime());
                prst.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (prst != null) {
                    prst.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Order> orderOutput() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from orders.pizzas");
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
