/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class CashPaymentUtilTest {

    @Test
    public void countChange() {
        CashPaymentUtil.fullAmount = 250;
        assertEquals(150, CashPaymentUtil.countChange(100));
    }

    @Test
    public void testPrivateConstructor() {
        Class<CashPaymentUtil> clazz = null;
        try {
            clazz = CashPaymentUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
