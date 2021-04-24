package com.peregud.pizza.view;

import com.peregud.pizza.model.Ingredient;

public interface CreatePizzaView {

    void greeting();

    void menuDough();

    void menuIngredients();

    String orderIngredient(Ingredient ingredient);

    void displayInfoAboutIngredient(Ingredient ingredient);

    void totalCalories(int totalCalories);

    void totalOrder(double totalOrder);

    void addDoughQuestion();

    void addIngredientsQuestion();

    void doughException();

    void ingredientNumberException();

    void displayOptions();

    void choiceView();

}
