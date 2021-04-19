package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCostUtilTest {

    @Test
    public void costFourCheese() {
        assertEquals(14.6, PizzaCostUtil.costFourCheese());
    }

    @Test
    public void costMargherita() {
        assertEquals(12.6, PizzaCostUtil.costMargherita());
    }

    @Test
    public void costMeatDelight() {
        assertEquals(28.4, PizzaCostUtil.costMeatDelight());
    }

    @Test
    public void costPepperoni() {
        assertEquals(21.6, PizzaCostUtil.costPepperoni());
    }

    @Test
    public void costVegetarian() {
        assertEquals(17.6, PizzaCostUtil.costVegetarian());
    }
}
