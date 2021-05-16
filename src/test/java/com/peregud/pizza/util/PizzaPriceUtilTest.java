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

class PizzaPriceUtilTest {

    @Test
    public void pricePizzaFourCheeseWithoutVAT() {
        assertEquals(18.98, RoundUtil.up(PizzaPriceUtil.pizzaPriceWithoutVAT(Pizza.FOUR_CHEESE)));
    }

    @Test
    public void pricePizzaFourCheeseIncludingVAT() {
        assertEquals(22.78, RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE)));
    }

    @Test
    public void pricePizzaMargheritaWithoutVAT() {
        assertEquals(16.38, RoundUtil.up(PizzaPriceUtil.pizzaPriceWithoutVAT(Pizza.MARGHERITA)));
    }

    @Test
    public void pricePizzaMargheritaIncludingVAT() {
        assertEquals(19.66, RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA)));
    }

    @Test
    public void pricePizzaMeatDelightWithoutVAT() {
        assertEquals(36.92, RoundUtil.up(PizzaPriceUtil.pizzaPriceWithoutVAT(Pizza.MEAT_DELIGHT)));
    }

    @Test
    public void pricePizzaMeatDelightIncludingVAT() {
        assertEquals(44.3, RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT)));
    }

    @Test
    public void pricePizzaPepperoniWithoutVAT() {
        assertEquals(28.08, RoundUtil.up(PizzaPriceUtil.pizzaPriceWithoutVAT(Pizza.PEPPERONI)));
    }

    @Test
    public void pricePizzaPepperoniIncludingVAT() {
        assertEquals(33.7, RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI)));
    }

    @Test
    public void pricePizzaVegetarianWithoutVAT() {
        assertEquals(22.88, RoundUtil.up(PizzaPriceUtil.pizzaPriceWithoutVAT(Pizza.VEGETARIAN)));
    }

    @Test
    public void pricePizzaVegetarianIncludingVAT() {
        assertEquals(27.46, RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN)));
    }

    @Test
    public void testPrivateConstructor() {
        Class<PizzaPriceUtil> clazz = null;
        try {
            clazz = PizzaPriceUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
