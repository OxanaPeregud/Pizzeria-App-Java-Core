package com.peregud.pizza.dao.util;

import com.peregud.pizza.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DBUtilTest {

    @Test
    void executePreparedStatement() throws SQLException {
        Connection conn = mock(Connection.class);
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        String sql = "sql";
        Map<Integer, Object> param = new HashMap<>();
        DBUtil.executePreparedStatement(sql, param);
    }

    @Test
    void executeResultSet() throws SQLException {
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        ResultSet rs = mock(ResultSet.class);
        when(conn.createStatement()).thenReturn(stmt);
        String sql = "sql";
        when(stmt.executeQuery(sql)).thenReturn(rs);
        Address address = mock(Address.class);
        DBUtil.executeResultSet(sql, address);
        assertEquals(address, DBUtil.executeResultSet(sql, address));
    }

    @Test
    void executeStatement() throws SQLException {
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        when(conn.createStatement()).thenReturn(stmt);
        String sql = "sql";
        DBUtil.executeStatement(sql);
    }

    @Test
    void executeBatch() throws SQLException {
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        when(conn.createStatement()).thenReturn(stmt);
        List<String> sqlList = Arrays.asList("sql1", "sql2");
        DBUtil.executeBatch(sqlList);
    }

    @Test
    void executeProcedure() throws SQLException {
        Connection conn = mock(Connection.class);
        CallableStatement cs = mock(CallableStatement.class);
        String sql = "sql";
        when(conn.prepareCall(sql)).thenReturn(cs);
        Map<Integer, Object> paramIn = new HashMap<>();
        Map<Integer, Integer> paramOut = new HashMap<>();
        DBUtil.executeProcedure(sql, paramIn, paramOut);
    }

    @Test
    public void testPrivateConstructor() {
        Class<DBUtil> clazz = null;
        try {
            clazz = DBUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
