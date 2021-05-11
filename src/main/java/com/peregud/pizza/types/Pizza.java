/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum Pizza {
    FOUR_CHEESE(Map.of(
            Ingredient.TRADITIONAL_DOUGH, 1,
            Ingredient.SAUCE, 1,
            Ingredient.CHEESE, 4,
            Ingredient.OREGANO, 1
    )),
    MARGHERITA(Map.of(
            Ingredient.TRADITIONAL_DOUGH, 1,
            Ingredient.SAUCE, 1,
            Ingredient.CHEESE, 2,
            Ingredient.TOMATOES, 2,
            Ingredient.OREGANO, 1
    )),
    MEAT_DELIGHT(Map.of(
            Ingredient.TRADITIONAL_DOUGH, 1,
            Ingredient.SAUCE, 1,
            Ingredient.CHEESE, 1,
            Ingredient.MEAT, 2,
            Ingredient.SAUSAGES, 2
    )),
    PEPPERONI(Map.of(
            Ingredient.TRADITIONAL_DOUGH, 1,
            Ingredient.SAUCE, 1,
            Ingredient.CHEESE, 1,
            Ingredient.MEAT, 3
    )),
    VEGETARIAN(Map.of(
            Ingredient.TRADITIONAL_DOUGH, 1,
            Ingredient.SAUCE, 1,
            Ingredient.CHEESE, 1,
            Ingredient.TOMATOES, 2,
            Ingredient.PEPPER, 2,
            Ingredient.OLIVES, 2
    ));
    private final Map<Ingredient, Integer> ingredients;

    public int getIngredientQuantity(Ingredient ingredient) {
        return ingredients.get(ingredient);
    }

    public List<Ingredient> listOfIngredients() {
        return new ArrayList<>(ingredients.keySet());
    }
}
