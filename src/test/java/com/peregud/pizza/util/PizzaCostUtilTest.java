package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import org.junit.jupiter.api.Test;

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
}
