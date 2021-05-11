/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.repository;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageRepositoryTest {
    StorageRepository storage = new StorageRepository();

    public void putToStorage() {
        storage.put(Ingredient.CHEESE, 10);
        storage.put(Ingredient.MEAT, 15);
        storage.put(Ingredient.OLIVES, 5);
        storage.put(Ingredient.OREGANO, 11);
        storage.put(Ingredient.PEPPER, 14);
        storage.put(Ingredient.SAUCE, 19);
        storage.put(Ingredient.SAUSAGES, 8);
        storage.put(Ingredient.TOMATOES, 10);
        storage.put(Ingredient.THIN_DOUGH, 11);
        storage.put(Ingredient.TRADITIONAL_DOUGH, 5);
    }

    @Test
    public void getStorage() {
        putToStorage();
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 10,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 5,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 19,
                Ingredient.TOMATOES, 10), StorageRepository.getSTORAGE());
    }

    @Test
    public void getIngredientQuantity_Cheese() {
        putToStorage();
        assertEquals(10, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat() {
        putToStorage();
        assertEquals(15, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_Olives() {
        putToStorage();
        assertEquals(5, storage.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void getIngredientQuantity_Oregano() {
        putToStorage();
        assertEquals(11, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_Pepper() {
        putToStorage();
        assertEquals(14, storage.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void getIngredientQuantity_Sauce() {
        putToStorage();
        assertEquals(19, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Sausages() {
        putToStorage();
        assertEquals(8, storage.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void getIngredientQuantity_Tomatoes() {
        putToStorage();
        assertEquals(10, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_ThinDough() {
        putToStorage();
        assertEquals(11, storage.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough() {
        putToStorage();
        assertEquals(5, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void changeIngredientQuantity_FourCheese() {
        putToStorage();
        storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 6,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 10,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), StorageRepository.getSTORAGE());
    }

    @Test
    public void changeIngredientQuantity_Margherita() {
        putToStorage();
        storage.changeIngredientQuantity(Pizza.MARGHERITA);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 8,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 10,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 8), StorageRepository.getSTORAGE());
    }

    @Test
    public void changeIngredientQuantity_MeatDelight() {
        putToStorage();
        storage.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 6,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 13,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), StorageRepository.getSTORAGE());
    }

    @Test
    public void changeIngredientQuantity_Pepperoni() {
        putToStorage();
        storage.changeIngredientQuantity(Pizza.PEPPERONI);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 12,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), StorageRepository.getSTORAGE());
    }

    @Test
    public void changeIngredientQuantity_Vegetarian() {
        putToStorage();
        storage.changeIngredientQuantity(Pizza.VEGETARIAN);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 12,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 3,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 8), StorageRepository.getSTORAGE());
    }

    @Test
    public void changeIngredientQuantity_Cheese() {
        storage.changeIngredientQuantity(Ingredient.CHEESE, 10);
        assertEquals(10, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void changeIngredientQuantity_Meat() {
        storage.changeIngredientQuantity(Ingredient.MEAT, 11);
        assertEquals(11, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void changeIngredientQuantity_Olives() {
        storage.changeIngredientQuantity(Ingredient.OLIVES, 1);
        assertEquals(1, storage.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void changeIngredientQuantity_Oregano() {
        storage.changeIngredientQuantity(Ingredient.OREGANO, 35);
        assertEquals(35, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void changeIngredientQuantity_Pepper() {
        storage.changeIngredientQuantity(Ingredient.PEPPER, 50);
        assertEquals(50, storage.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void changeIngredientQuantity_Sauce() {
        storage.changeIngredientQuantity(Ingredient.SAUCE, 70);
        assertEquals(70, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void changeIngredientQuantity_Sausages() {
        storage.changeIngredientQuantity(Ingredient.SAUSAGES, 2);
        assertEquals(2, storage.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void changeIngredientQuantity_Tomatoes() {
        storage.changeIngredientQuantity(Ingredient.TOMATOES, 12);
        assertEquals(12, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void changeIngredientQuantity_ThinDough() {
        storage.changeIngredientQuantity(Ingredient.THIN_DOUGH, 30);
        assertEquals(30, storage.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void changeIngredientQuantity_TraditionalDough() {
        storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, 3);
        assertEquals(3, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void removeOneIngredient_Cheese() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.CHEESE);
        assertEquals(9, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void removeOneIngredient_Meat() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.MEAT);
        assertEquals(14, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void removeOneIngredient_Olives() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.OLIVES);
        assertEquals(4, storage.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void removeOneIngredient_Oregano() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.OREGANO);
        assertEquals(10, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void removeOneIngredient_Pepper() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.PEPPER);
        assertEquals(13, storage.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void removeOneIngredient_Sauce() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.SAUCE);
        assertEquals(18, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void removeOneIngredient_Sausages() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.SAUSAGES);
        assertEquals(7, storage.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void removeOneIngredient_Tomatoes() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.TOMATOES);
        assertEquals(9, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void removeOneIngredient_ThinDough() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.THIN_DOUGH);
        assertEquals(10, storage.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void removeOneIngredient_TraditionalDough() {
        putToStorage();
        storage.removeOneIngredient(Ingredient.TRADITIONAL_DOUGH);
        assertEquals(4, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }
}
