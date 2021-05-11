/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCaloriesUtilTest {

    @Test
    public void caloriesPizzaFourCheese() {
        assertEquals(1750, PizzaCaloriesUtil.pizzaCalories(Pizza.FOUR_CHEESE));
    }

    @Test
    public void caloriesPizzaMargherita() {
        assertEquals(1070, PizzaCaloriesUtil.pizzaCalories(Pizza.MARGHERITA));
    }

    @Test
    public void caloriesPizzaMeatDelight() {
        assertEquals(1740, PizzaCaloriesUtil.pizzaCalories(Pizza.MEAT_DELIGHT));
    }

    @Test
    public void caloriesPizzaPepperoni() {
        assertEquals(1320, PizzaCaloriesUtil.pizzaCalories(Pizza.PEPPERONI));
    }

    @Test
    public void caloriesPizzaVegetarian() {
        assertEquals(990, PizzaCaloriesUtil.pizzaCalories(Pizza.VEGETARIAN));
    }
}
