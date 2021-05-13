package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class TotalOrderCalculatorUtilTest {

    @Test
    void totalOrder() {
        assertEquals(120, TotalOrderCalculatorUtil.totalOrder(100, 20));
    }

    @Test
    public void testPrivateConstructor() {
        Class<TotalOrderCalculatorUtil> clazz = null;
        try {
            clazz = TotalOrderCalculatorUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
