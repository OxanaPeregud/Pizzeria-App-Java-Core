/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.types;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {

    @Test
    public void getIngredients_FourCheese() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 4,
                Ingredient.OREGANO, 1),
                Pizza.FOUR_CHEESE.getIngredients());
    }

    @Test
    public void getIngredients_Margherita() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 2,
                Ingredient.TOMATOES, 2,
                Ingredient.OREGANO, 1),
                Pizza.MARGHERITA.getIngredients());
    }

    @Test
    public void getIngredients_MeatDelight() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.MEAT, 2,
                Ingredient.SAUSAGES, 2),
                Pizza.MEAT_DELIGHT.getIngredients());
    }

    @Test
    public void getIngredients_Pepperoni() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.MEAT, 3),
                Pizza.PEPPERONI.getIngredients());
    }

    @Test
    public void getIngredients_Vegetarian() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.TOMATOES, 2,
                Ingredient.PEPPER, 2,
                Ingredient.OLIVES, 2),
                Pizza.VEGETARIAN.getIngredients());
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_FourCheese() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_FourCheese() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_FourCheese() {
        assertEquals(4, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Oregano_FourCheese() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Margherita() {
        assertEquals(1, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Margherita() {
        assertEquals(1, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Margherita() {
        assertEquals(2, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Tomatoes_Margherita() {
        assertEquals(2, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_Oregano_Margherita() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_MeatDelight() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_MeatDelight() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_MeatDelight() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat_MeatDelight() {
        assertEquals(2, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_Sausages_MeatDelight() {
        assertEquals(2, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Pepperoni() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Pepperoni() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Pepperoni() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat_Pepperoni() {
        assertEquals(3, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Vegetarian() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Vegetarian() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Vegetarian() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Tomatoes_Vegetarian() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_Pepper_Vegetarian() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void getIngredientQuantity_Olives_Vegetarian() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.OLIVES));
    }
}
