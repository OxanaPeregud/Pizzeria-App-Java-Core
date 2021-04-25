package com.peregud.pizza.view;

import com.peregud.pizza.model.Pizza;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    String orderPizza(Pizza pizza, double price);

    void displayInfoAboutPizza(Pizza pizza);

    void displayInfoPizza();

    void totalOrder(double totalOrder, int size);

    void pizzaNumberException();

    void addSupplementIngredients();

    void displayOptions();

    void choiceView();

}
