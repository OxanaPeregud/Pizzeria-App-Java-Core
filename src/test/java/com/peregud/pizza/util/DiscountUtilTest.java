/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class DiscountUtilTest {

    @Test
    public void discountForTwoItems() {
        assertEquals(90, DiscountUtil.discountForTwoItems(100));
    }

    @Test
    public void discountForThreeAndMoreItems() {
        assertEquals(80, DiscountUtil.discountForThreeAndMoreItems(100));
    }

    @Test
    public void discountForOrderOnSpecificDay() {
        assertEquals(85, DiscountUtil.discountForOrderOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor2PizzasOnSpecificDay() {
        assertEquals(75, DiscountUtil.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor3AndMorePizzasOnSpecificDay() {
        assertEquals(65, DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }

    @Test
    public void testPrivateConstructor() {
        Class<DiscountUtil> clazz = null;
        try {
            clazz = DiscountUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
