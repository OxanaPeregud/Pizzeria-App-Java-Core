package com.peregud.pizza.service;

import java.util.List;

public class IngredientCaloriesCalculatorService {
    private final List<Integer> totalCalories;

    public IngredientCaloriesCalculatorService(List<Integer> totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void add(int calories) {
        totalCalories.add(calories);
    }

    public int countTotalCalories() {
        return totalCalories.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
