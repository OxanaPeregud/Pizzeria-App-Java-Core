/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PizzaCostUtil {

    public static double pizzaCost(Pizza pizza) {
        double sum = 0;
        for (Ingredient ingredient : pizza.listOfIngredients()) {
            sum += ingredient.getCostPerUnit() * pizza.getIngredientQuantity(ingredient);
        }
        return sum;
    }
}
