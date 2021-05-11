/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PizzaCostUtil {

    public double pizzaCost(Pizza pizza) {
        double sum = 0;
        for (Ingredient ingredient : pizza.listOfIngredients()) {
            sum += ingredient.getCostPerUnit() * pizza.getIngredientQuantity(ingredient);
        }
        return sum;
    }
}
