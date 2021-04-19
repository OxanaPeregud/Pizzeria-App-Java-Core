package com.peregud.pizza.view;

import com.peregud.pizza.model.Pizza;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    String orderPizza(Pizza pizza, double price);

    void displayInfoPizzaFourCheese();

    void displayInfoPizzaMargherita();

    void displayInfoPizzaMeatDelight();

    void displayInfoPizzaPepperoni();

    void displayInfoPizzaVegetarian();

    void displayInfoPizza();

    void totalOrder(double totalOrder, int size);

    void discountFor2Pizzas(double totalOrder);

    void discountFor3AndMorePizzas(double totalOrder);

    void discountForOrderOnSpecificDay(double totalOrder);

    void amountToPay(double totalOrder);

    void pizzaNumberException();

    void addSupplementIngredients();

    void displayOptions();

    void choiceView();

}
