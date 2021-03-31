package com.peregud.pizza.repository;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.model.Supplier;

import java.util.Map;

public interface IngredientStorageRepository {

    Map<Ingredient, Integer> getStorage();

    int getIngredientQuantity(Ingredient ingredient);

    void changeIngredientQuantity(Pizza pizza);

    void changeIngredientQuantity(Ingredient ingredient, int newQuantity);

    void removeOneIngredient(Ingredient ingredient);

    void changeDeliveredIngredient(Supplier supplier);

    Iterable<Map.Entry<Ingredient, Integer>> entrySet();

}