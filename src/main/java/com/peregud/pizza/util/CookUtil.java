/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import com.peregud.pizza.repository.StorageRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CookUtil {
    private final StorageRepository STORAGE = new StorageRepository();

    public void cookPizza(Pizza pizza) {
        STORAGE.changeIngredientQuantity(pizza);
    }

    public void cookIngredient(Ingredient ingredient) {
        STORAGE.removeOneIngredient(ingredient);
    }
}
