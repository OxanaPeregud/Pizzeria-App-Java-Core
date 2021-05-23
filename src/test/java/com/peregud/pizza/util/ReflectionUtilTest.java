/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Customer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ReflectionUtilTest {

    @Test
    void annotatedField() {
        assertEquals("customer_id", ReflectionUtil.annotatedField(Customer.class, "id"));
    }

    @Test
    void testException() {
        try {
            ReflectionUtil.annotatedField(Customer.class, "customer_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrivateConstructor() {
        Class<ReflectionUtil> clazz = null;
        try {
            clazz = ReflectionUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
