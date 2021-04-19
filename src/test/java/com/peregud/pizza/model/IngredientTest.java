package com.peregud.pizza.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    public void getCostPerUnit_Cheese() {
        assertEquals(2.5, Ingredient.CHEESE.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Crust() {
        assertEquals(2, Ingredient.CRUST.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Meat() {
        assertEquals(5.2, Ingredient.MEAT.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Olives() {
        assertEquals(2.5, Ingredient.OLIVES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Oregano() {
        assertEquals(1.1, Ingredient.OREGANO.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Pepper() {
        assertEquals(1.8, Ingredient.PEPPER.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Sauce() {
        assertEquals(1, Ingredient.SAUCE.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Sausages() {
        assertEquals(6, Ingredient.SAUSAGES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_ThinDough() {
        assertEquals(1.9, Ingredient.THIN_DOUGH.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Tomatoes() {
        assertEquals(1.5, Ingredient.TOMATOES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_TraditionalDough() {
        assertEquals(2.5, Ingredient.TRADITIONAL_DOUGH.getCostPerUnit());
    }

    @Test
    public void getCalories_Cheese() {
        assertEquals(360, Ingredient.CHEESE.getCalories());
    }

    @Test
    public void getCalories_Crust() {
        assertEquals(400, Ingredient.CRUST.getCalories());
    }

    @Test
    public void getCalories_Meat() {
        assertEquals(220, Ingredient.MEAT.getCalories());
    }

    @Test
    public void getCalories_Olives() {
        assertEquals(115, Ingredient.OLIVES.getCalories());
    }

    @Test
    public void getCalories_Oregano() {
        assertEquals(10, Ingredient.OREGANO.getCalories());
    }

    @Test
    public void getCalories_Pepper() {
        assertEquals(30, Ingredient.PEPPER.getCalories());
    }

    @Test
    public void getCalories_Sauce() {
        assertEquals(50, Ingredient.SAUCE.getCalories());
    }

    @Test
    public void getCalories_Sausages() {
        assertEquals(320, Ingredient.SAUSAGES.getCalories());
    }

    @Test
    public void getCalories_ThinDough() {
        assertEquals(150, Ingredient.THIN_DOUGH.getCalories());
    }

    @Test
    public void getCalories_TraditionalDough() {
        assertEquals(250, Ingredient.TRADITIONAL_DOUGH.getCalories());
    }

    @Test
    public void getCalories_Tomatoes() {
        assertEquals(20, Ingredient.TOMATOES.getCalories());
    }
}
