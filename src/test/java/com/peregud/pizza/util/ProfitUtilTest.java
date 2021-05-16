/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class ProfitUtilTest {

    @Test
    public void profitPercentage() {
        assertEquals(130, ProfitUtil.profitPercentage(100));
    }

    @Test
    public void testPrivateConstructor() {
        Class<ProfitUtil> clazz = null;
        try {
            clazz = ProfitUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
