/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.types.Ingredient;

public interface CreatePizzaView {

    void greeting();

    void menuDough();

    void menuIngredients();

    String orderIngredient(Ingredient ingredient);

    void displayInfoAboutIngredient(Ingredient ingredient);

    void totalOrder(double totalOrder);

    void addIngredientsQuestion();

    void doughException();

    void ingredientNumberException();

    void displayOptions();

    void choiceView();

}
