/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCaloriesCalculatorUtilTest {

    @Test
    public void countTotalCalories() {
        IngredientCaloriesCalculatorUtil.add(100);
        IngredientCaloriesCalculatorUtil.add(200);
        IngredientCaloriesCalculatorUtil.add(300);
        assertEquals(600, IngredientCaloriesCalculatorUtil.countTotalCalories());
    }

    @Test
    public void testPrivateConstructor() {
        Class<IngredientCaloriesCalculatorUtil> clazz = null;
        try {
            clazz = IngredientCaloriesCalculatorUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
