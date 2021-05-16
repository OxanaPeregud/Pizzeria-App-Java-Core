/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CheckUtilTest {

    @Test
    void add() {
        String str = "pizza1";
        CheckUtil.add(str);
        List<String> check = List.of(str);
        assertEquals(check, CheckUtil.getCheck());
    }

    @Test
    public void testPrivateConstructor() {
        Class<CheckUtil> clazz = null;
        try {
            clazz = CheckUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
