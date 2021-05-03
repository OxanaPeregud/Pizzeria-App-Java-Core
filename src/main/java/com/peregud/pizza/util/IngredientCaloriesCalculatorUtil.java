/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IngredientCaloriesCalculatorUtil {
    private static final List<Integer> TOTAL_CALORIES;

    static {
        TOTAL_CALORIES = new ArrayList<>();
    }

    public static void add(int calories) {
        TOTAL_CALORIES.add(calories);
    }

    public static int countTotalCalories() {
        return TOTAL_CALORIES.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
