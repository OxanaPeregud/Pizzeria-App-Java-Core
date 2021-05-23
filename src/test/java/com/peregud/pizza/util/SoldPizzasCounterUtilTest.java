/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoldPizzasCounterUtilTest {

    @Test
    public void soldPizzas_success() {
        Order order = new Order("order", 10.0, "1");
        List<Order> list = List.of(order);
        String pizzaName = "order";
        assertEquals(list, SoldPizzasCounterUtil.soldPizzas(list, pizzaName));
    }

    @Test
    public void soldPizzas_fail() {
        Order order = new Order("order", 10.0, "1");
        List<Order> list = List.of(order);
        String pizzaName = "order1";
        assertNotEquals(list, SoldPizzasCounterUtil.soldPizzas(list, pizzaName));
    }

    @Test
    public void testPrivateConstructor() {
        Class<SoldPizzasCounterUtil> clazz = null;
        try {
            clazz = SoldPizzasCounterUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
