/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class IngredientCaloriesCalculatorUtil {
    private final List<Integer> TOTAL_CALORIES = new ArrayList<>();

    public void add(int calories) {
        TOTAL_CALORIES.add(calories);
    }

    public int countTotalCalories() {
        return TOTAL_CALORIES.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
