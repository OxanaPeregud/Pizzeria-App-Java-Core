/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PizzaCaloriesUtil {

    public int pizzaCalories(Pizza pizza) {
        int sum = 0;
        for (Ingredient ingredient : pizza.listOfIngredients()) {
            sum += pizza.getIngredientQuantity(ingredient) * ingredient.getCalories();
        }
        return sum;
    }
}
