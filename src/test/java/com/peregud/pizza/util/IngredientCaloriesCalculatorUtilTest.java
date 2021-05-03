/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCaloriesCalculatorUtilTest {

    @Test
    public void countTotalCalories() {
        IngredientCaloriesCalculatorUtil.add(100);
        IngredientCaloriesCalculatorUtil.add(200);
        IngredientCaloriesCalculatorUtil.add(300);
        assertEquals(600, IngredientCaloriesCalculatorUtil.countTotalCalories());
    }
}