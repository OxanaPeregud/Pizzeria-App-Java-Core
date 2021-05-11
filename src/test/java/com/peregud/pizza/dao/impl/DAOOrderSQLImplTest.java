package com.peregud.pizza.dao.impl;

import com.peregud.pizza.model.Order;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DAOOrderSQLImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource dataSource = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Order order;
        assertNotNull(dataSource);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(dataSource.getConnection()).thenReturn(conn);

        order = new Order();
        order.setId(1);
        order.setPizza("Pizza");
        order.setPrice(0.0);
        order.setOrderTime("Time");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(order.getPizza());
        when(rs.getDouble(3)).thenReturn(order.getPrice());
        when(rs.getString(4)).thenReturn(order.getOrderTime());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource dataSource = mock(DataSource.class);
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        List<Order> orderList = Arrays.asList(order1, order2);
        new DAOOrderSQLImpl(dataSource).save(orderList);
    }

    @Test
    void testSave() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Order order = mock(Order.class);
        new DAOOrderSQLImpl(dataSource).save(order);
    }

    @Test
    void get() {
        DataSource dataSource = mock(DataSource.class);
        DAOOrderSQLImpl dao = new DAOOrderSQLImpl(dataSource);
        Assertions.assertNull(dao.get(0));
    }

    @Test
    void update() {
        DataSource dataSource = mock(DataSource.class);
        Order order = mock(Order.class);
        new DAOOrderSQLImpl(dataSource).update(order);
    }

    @Test
    void delete() {
        DataSource dataSource = mock(DataSource.class);
        new DAOOrderSQLImpl(dataSource).delete(0);
    }

    @Test
    void getAll() {
        DataSource dataSource = mock(DataSource.class);
        new DAOOrderSQLImpl(dataSource).getAll();
    }

    @Test
    public void testConstructor() {
        new DAOOrderSQLImpl();
    }
}
