/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.types.Pizza;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    String orderPizza(Pizza pizza, double price);

    void displayInfoAboutPizza(Pizza pizza);

    void displayInfoPizza();

    void totalOrder(double totalOrder);

    void pizzaNumberException();

    void addSupplementIngredients();

    void displayOptions();

    void choiceView();

}
