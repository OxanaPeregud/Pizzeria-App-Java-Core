/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.StorageRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CookUtil {
    private static final StorageRepository STORAGE;

    static {
        STORAGE = new StorageRepository();
    }

    public static void cookPizza(Pizza pizza) {
        STORAGE.changeIngredientQuantity(pizza);
    }

    public static void cookIngredient(Ingredient ingredient) {
        STORAGE.removeOneIngredient(ingredient);
    }
}
