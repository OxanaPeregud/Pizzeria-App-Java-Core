/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.service.IngredientOrderCalculatorService;
import com.peregud.pizza.types.Ingredient;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IngredientOrderUtilTest {

    @Test
    void chooseIngredient() {
        assertEquals(3.9, IngredientOrderUtil.chooseIngredient(Ingredient.CHEESE));
    }

    @Test
    void getIngredientOrder() {
        List<Double> list = new ArrayList<>();
        assertEquals(new IngredientOrderCalculatorService(list), IngredientOrderUtil.getIngredientOrder());
    }

    @Test
    public void testPrivateConstructor() {
        Class<IngredientOrderUtil> clazz = null;
        try {
            clazz = IngredientOrderUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
