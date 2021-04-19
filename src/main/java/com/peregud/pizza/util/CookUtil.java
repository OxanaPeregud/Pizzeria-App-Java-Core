package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.StorageRepository;

public final class CookUtil {
    private static final StorageRepository STORAGE;

    static {
        STORAGE = new StorageRepository();
    }

    private CookUtil() {
    }

    public static void cookPizza(Pizza pizza) {
        STORAGE.changeIngredientQuantity(pizza);
    }

    public static void cookIngredient(Ingredient ingredient) {
        STORAGE.removeOneIngredient(ingredient);
    }
}
