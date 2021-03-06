/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.repository;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import com.peregud.pizza.types.Supplier;

import java.util.Map;

public interface IngredientStorageRepository {

    int getIngredientQuantity(Ingredient ingredient);

    void changeIngredientQuantity(Pizza pizza);

    void changeIngredientQuantity(Ingredient ingredient, int newQuantity);

    void removeOneIngredient(Ingredient ingredient);

    void changeDeliveredIngredient(Supplier supplier);

    Iterable<Map.Entry<Ingredient, Integer>> entrySet();

    void put(Ingredient ingredient, int quantity);

}