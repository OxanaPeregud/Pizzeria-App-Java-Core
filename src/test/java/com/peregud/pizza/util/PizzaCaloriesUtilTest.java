package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCaloriesUtilTest {

    @Test
    public void caloriesPizzaFourCheese() {
        assertEquals(1750, PizzaCaloriesUtil.caloriesPizzaFourCheese());
    }

    @Test
    public void caloriesPizzaMargherita() {
        assertEquals(1420, PizzaCaloriesUtil.caloriesPizzaMargherita());
    }

    @Test
    public void caloriesPizzaMeatDelight() {
        assertEquals(1740, PizzaCaloriesUtil.caloriesPizzaMeatDelight());
    }

    @Test
    public void caloriesPizzaPepperoni() {
        assertEquals(1320, PizzaCaloriesUtil.caloriesPizzaPepperoni());
    }

    @Test
    public void caloriesPizzaVegetarian() {
        assertEquals(990, PizzaCaloriesUtil.caloriesPizzaVegetarian());
    }
}
