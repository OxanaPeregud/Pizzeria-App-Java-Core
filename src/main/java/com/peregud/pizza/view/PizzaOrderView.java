package com.peregud.pizza.view;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    String orderPizzaFourCheese();

    String orderPizzaMargherita();

    String orderPizzaMeatDelight();

    String orderPizzaPepperoni();

    String orderPizzaVegetarian();

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

    void paymentChoice();

    void pizzaNumberException();

    void paymentChoiceException();

    void addSupplementIngredients();

    void displayOptions();

    void choiceView();

}
