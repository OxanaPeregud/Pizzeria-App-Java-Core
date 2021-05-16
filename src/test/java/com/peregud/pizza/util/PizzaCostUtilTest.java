/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Pizza;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCostUtilTest {

    @Test
    public void costFourCheese() {
        assertEquals(14.6, PizzaCostUtil.pizzaCost(Pizza.FOUR_CHEESE));
    }

    @Test
    public void costMargherita() {
        assertEquals(12.6, PizzaCostUtil.pizzaCost(Pizza.MARGHERITA));
    }

    @Test
    public void costMeatDelight() {
        assertEquals(28.4, PizzaCostUtil.pizzaCost(Pizza.MEAT_DELIGHT));
    }

    @Test
    public void costPepperoni() {
        assertEquals(21.6, PizzaCostUtil.pizzaCost(Pizza.PEPPERONI));
    }

    @Test
    public void costVegetarian() {
        assertEquals(17.6, PizzaCostUtil.pizzaCost(Pizza.VEGETARIAN));
    }

    @Test
    public void testPrivateConstructor() {
        Class<PizzaCostUtil> clazz = null;
        try {
            clazz = PizzaCostUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
