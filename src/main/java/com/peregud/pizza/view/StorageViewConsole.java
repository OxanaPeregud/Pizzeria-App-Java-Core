/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.repository.StorageRepository;

import java.util.Map;

public class StorageViewConsole implements StorageView {
    private static final StorageRepository STORAGE = new StorageRepository();

    @Override
    public void displayStorage() {
        System.out.println("Ingredients in storage:");
        for (Map.Entry<Ingredient, Integer> entry : STORAGE.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Override
    public void showLackOfIngredients() {
        for (Map.Entry<Ingredient, Integer> entry : STORAGE.entrySet()) {
            Integer value = entry.getValue();
            if (value <= 10)
                System.out.println("Ingredient " + entry.getKey() + " is running out, quantity is " + entry.getValue());
        }
    }
}
