/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.repository;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.types.Pizza;
import com.peregud.pizza.types.Supplier;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StorageRepository implements IngredientStorageRepository {
    @Getter
    private static final Map<Ingredient, Integer> STORAGE = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public StorageRepository() {
        STORAGE.put(Ingredient.CHEESE, 90);
        STORAGE.put(Ingredient.MEAT, 82);
        STORAGE.put(Ingredient.OLIVES, 5);
        STORAGE.put(Ingredient.OREGANO, 78);
        STORAGE.put(Ingredient.PEPPER, 53);
        STORAGE.put(Ingredient.SAUCE, 15);
        STORAGE.put(Ingredient.SAUSAGES, 8);
        STORAGE.put(Ingredient.TOMATOES, 60);
        STORAGE.put(Ingredient.THIN_DOUGH, 11);
        STORAGE.put(Ingredient.TRADITIONAL_DOUGH, 15);
    }

    @Override
    public int getIngredientQuantity(Ingredient ingredient) {
        return STORAGE.get(ingredient);
    }

    @Override
    public void changeIngredientQuantity(Pizza pizza) {
        pizza.getIngredients().forEach((ingredient, ingredientsForPizza) -> {
            Integer oldQuantity = STORAGE.get(ingredient);
            int newQuantity = oldQuantity - ingredientsForPizza;
            STORAGE.put(ingredient, newQuantity);
        });
    }

    @Override
    public void changeIngredientQuantity(Ingredient ingredient, int newQuantity) {
        STORAGE.replace(ingredient, newQuantity);
    }

    @Override
    public void removeOneIngredient(Ingredient ingredient) {
        changeIngredientQuantity(ingredient, getIngredientQuantity(ingredient) - 1);
    }

    @Override
    public void changeDeliveredIngredient(Supplier supplier) {
        changeIngredientQuantity(supplier.getIngredient(), getIngredientQuantity(supplier.getIngredient())
                + scanner.nextInt());
    }

    @Override
    public Iterable<Map.Entry<Ingredient, Integer>> entrySet() {
        return STORAGE.entrySet();
    }

    @Override
    public void put(Ingredient ingredient, int quantity) {
        STORAGE.put(ingredient, quantity);
    }
}
