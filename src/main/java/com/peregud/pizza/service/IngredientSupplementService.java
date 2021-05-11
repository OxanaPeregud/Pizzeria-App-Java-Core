/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.util.ChoiceUtil;
import com.peregud.pizza.util.IngredientOrderUtil;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IngredientSupplementService {
    private final CreatePizzaView createPizzaView = new CreatePizzaViewConsole();
    private final PizzaOrderView pizzaOrderView = new PizzaOrderViewConsole();
    private static final Map<Integer, Ingredient> INGREDIENTS;

    static {
        INGREDIENTS = new HashMap<>();
        INGREDIENTS.put(1, Ingredient.CHEESE);
        INGREDIENTS.put(2, Ingredient.MEAT);
        INGREDIENTS.put(3, Ingredient.SAUSAGES);
        INGREDIENTS.put(4, Ingredient.OLIVES);
        INGREDIENTS.put(5, Ingredient.TOMATOES);
        INGREDIENTS.put(6, Ingredient.PEPPER);
        INGREDIENTS.put(7, Ingredient.OREGANO);
        INGREDIENTS.put(8, Ingredient.SAUCE);
    }

    public void chooseIngredients() throws IOException {
        createPizzaView.menuIngredients();
        int choice = CheckScannerInputUtil.checkInt();
        if (INGREDIENTS.get(choice) != null) {
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    IngredientOrderUtil.chooseIngredient(Ingredient.CHEESE);
                    break;
                case MEAT:
                    IngredientOrderUtil.chooseIngredient(Ingredient.MEAT);
                    break;
                case SAUSAGES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.SAUSAGES);
                    break;
                case OLIVES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.OLIVES);
                    break;
                case TOMATOES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.TOMATOES);
                    break;
                case PEPPER:
                    IngredientOrderUtil.chooseIngredient(Ingredient.PEPPER);
                    break;
                case OREGANO:
                    IngredientOrderUtil.chooseIngredient(Ingredient.OREGANO);
                    break;
                case SAUCE:
                    IngredientOrderUtil.chooseIngredient(Ingredient.SAUCE);
                    break;
            }
        } else {
            createPizzaView.ingredientNumberException();
            chooseIngredients();
        }
        pizzaOrderView.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }
}
