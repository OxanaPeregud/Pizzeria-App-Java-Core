package com.peregud.pizza.dao.impl;

import com.peregud.pizza.model.Customer;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DAOCustomerSQLImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource dataSource = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Customer customer;
        assertNotNull(dataSource);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(dataSource.getConnection()).thenReturn(conn);

        customer = new Customer();
        customer.setId(1);
        customer.setFirstName("First Name");
        customer.setLastName("Last Name");
        customer.setCardNumber("Card Number");
        customer.setOrderID(1);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(customer.getFirstName());
        when(rs.getString(3)).thenReturn(customer.getLastName());
        when(rs.getString(4)).thenReturn(customer.getCardNumber());
        when(rs.getInt(5)).thenReturn(customer.getOrderID());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource dataSource = mock(DataSource.class);
        Customer customer1 = mock(Customer.class);
        Customer customer2 = mock(Customer.class);
        List<Customer> customerList = Arrays.asList(customer1, customer2);
        new DAOCustomerSQLImpl(dataSource).save(customerList);
    }

    @Test
    void testSave() {
        DataSource dataSource = mock(DataSource.class);
        Customer customer = mock(Customer.class);
        new DAOCustomerSQLImpl(dataSource).save(customer);
    }

    @Test
    void get() {
        DataSource dataSource = mock(DataSource.class);
        DAOCustomerSQLImpl dao = new DAOCustomerSQLImpl(dataSource);
        Assertions.assertNull(dao.get(0));
    }

    @Test
    void update() {
        DataSource dataSource = mock(DataSource.class);
        Customer customer = mock(Customer.class);
        new DAOCustomerSQLImpl(dataSource).update(customer);
    }

    @Test
    void delete() {
        DataSource dataSource = mock(DataSource.class);
        new DAOCustomerSQLImpl(dataSource).delete(0);
    }

    @Test
    void getAll() {
        DataSource dataSource = mock(DataSource.class);
        new DAOCustomerSQLImpl(dataSource).getAll();
    }

    @Test
    public void testConstructor() {
        new DAOCustomerSQLImpl();
    }
}
