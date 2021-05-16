/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import com.peregud.pizza.repository.StorageRepository;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class CookUtilTest {
    StorageRepository storage = new StorageRepository();

    @Test
    public void pizzaFourCheese_TraditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaFourCheese_Sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaFourCheese_Cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 4, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaFourCheese_Oregano() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMargherita_TraditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMargherita_Sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMargherita_Cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMargherita_Tomatoes() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaMargherita_Oregano() {
        int oldQuantityOregano = storage.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantityOregano - 1, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMeatDelight_TraditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMeatDelight_Sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMeatDelight_Cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMeatDelight_Meat() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaMeatDelight_Sausages() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUSAGES);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void pizzaPepperoni_TraditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaPepperoni_Sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaPepperoni_Cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaPepperoni_Meat() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 3, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaVegetarian_TraditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaVegetarian_Sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaVegetarian_Cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaVegetarian_Tomatoes() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaVegetarian_Pepper() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.PEPPER);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void pizzaVegetarian_Olives() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.OLIVES);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, storage.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void thinDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.THIN_DOUGH);
        CookUtil.cookIngredient(Ingredient.THIN_DOUGH);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void traditionalDough() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookIngredient(Ingredient.TRADITIONAL_DOUGH);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void cheese() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookIngredient(Ingredient.CHEESE);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void meat() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookIngredient(Ingredient.MEAT);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void sausages() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUSAGES);
        CookUtil.cookIngredient(Ingredient.SAUSAGES);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void olives() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.OLIVES);
        CookUtil.cookIngredient(Ingredient.OLIVES);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void tomatoes() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookIngredient(Ingredient.TOMATOES);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pepper() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.PEPPER);
        CookUtil.cookIngredient(Ingredient.PEPPER);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void oregano() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookIngredient(Ingredient.OREGANO);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void sauce() {
        int oldQuantity = storage.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookIngredient(Ingredient.SAUCE);
        assertEquals(oldQuantity - 1, storage.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void testPrivateConstructor() {
        Class<CookUtil> clazz = null;
        try {
            clazz = CookUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
