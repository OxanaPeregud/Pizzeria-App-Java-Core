package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;

public final class PizzaCaloriesUtil {

    private PizzaCaloriesUtil() {
    }

    public static int pizzaCalories(Pizza pizza) {
        int sum = 0;
        for (Ingredient ingredient : pizza.listOfIngredients()) {
            sum += pizza.getIngredientQuantity(ingredient) * ingredient.getCalories();
        }
        return sum;
    }
}
