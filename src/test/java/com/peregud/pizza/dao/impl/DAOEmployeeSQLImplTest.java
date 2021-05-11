package com.peregud.pizza.dao.impl;

import com.peregud.pizza.model.Employee;
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
class DAOEmployeeSQLImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource dataSource = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Employee employee;
        assertNotNull(dataSource);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(dataSource.getConnection()).thenReturn(conn);

        employee = new Employee();
        employee.setId(1);
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        employee.setSalary(0);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(employee.getFirstName());
        when(rs.getString(3)).thenReturn(employee.getLastName());
        when(rs.getDouble(4)).thenReturn(employee.getSalary());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource dataSource = mock(DataSource.class);
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        List<Employee> employeeList = Arrays.asList(employee1, employee2);
        new DAOEmployeeSQLImpl(dataSource).save(employeeList);
    }

    @Test
    void testSave() {
        DataSource dataSource = mock(DataSource.class);
        Employee employee = mock(Employee.class);
        new DAOEmployeeSQLImpl(dataSource).save(employee);
    }

    @Test
    void get() {
        DataSource dataSource = mock(DataSource.class);
        DAOEmployeeSQLImpl dao = new DAOEmployeeSQLImpl(dataSource);
        Assertions.assertNull(dao.get(0));
    }

    @Test
    void update() {
        DataSource dataSource = mock(DataSource.class);
        Employee employee = mock(Employee.class);
        new DAOEmployeeSQLImpl(dataSource).update(employee);
    }

    @Test
    void delete() {
        DataSource dataSource = mock(DataSource.class);
        new DAOEmployeeSQLImpl(dataSource).delete(0);
    }

    @Test
    void getAll() {
        DataSource dataSource = mock(DataSource.class);
        new DAOEmployeeSQLImpl(dataSource).getAll();
    }

    @Test
    public void testConstructor() {
        new DAOEmployeeSQLImpl();
    }
}
