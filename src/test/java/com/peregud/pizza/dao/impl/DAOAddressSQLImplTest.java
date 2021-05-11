package com.peregud.pizza.dao.impl;

import com.peregud.pizza.model.Address;
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
class DAOAddressSQLImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource dataSource = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Address address;
        assertNotNull(dataSource);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(dataSource.getConnection()).thenReturn(conn);

        address = new Address();
        address.setId(1);
        address.setStreet("Street");
        address.setHouse(0);
        address.setApartment(0);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(address.getStreet());
        when(rs.getInt(3)).thenReturn(address.getHouse());
        when(rs.getInt(4)).thenReturn(address.getApartment());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource dataSource = mock(DataSource.class);
        Address address1 = mock(Address.class);
        Address address2 = mock(Address.class);
        List<Address> addressList = Arrays.asList(address1, address2);
        new DAOAddressSQLImpl(dataSource).save(addressList);
    }

    @Test
    void testSave() {
        DataSource dataSource = mock(DataSource.class);
        Address address = mock(Address.class);
        new DAOAddressSQLImpl(dataSource).save(address);
    }

    @Test
    void get() {
        DataSource dataSource = mock(DataSource.class);
        DAOAddressSQLImpl dao = new DAOAddressSQLImpl(dataSource);
        Assertions.assertNull(dao.get(0));
    }

    @Test
    void update() {
        DataSource dataSource = mock(DataSource.class);
        Address address = mock(Address.class);
        new DAOAddressSQLImpl(dataSource).update(address);
    }

    @Test
    void delete() {
        DataSource dataSource = mock(DataSource.class);
        new DAOAddressSQLImpl(dataSource).delete(0);
    }

    @Test
    void getAll() {
        DataSource dataSource = mock(DataSource.class);
        new DAOAddressSQLImpl(dataSource).getAll();
    }

    @Test
    public void testConstructor() {
        new DAOAddressSQLImpl();
    }
}
