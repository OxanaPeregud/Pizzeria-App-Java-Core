package com.peregud.pizza.util;

import java.util.ArrayList;
import java.util.List;

public final class IngredientCaloriesCalculatorUtil {
    private static final List<Integer> TOTAL_CALORIES;

    static {
        TOTAL_CALORIES = new ArrayList<>();
    }

    private IngredientCaloriesCalculatorUtil() {
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
