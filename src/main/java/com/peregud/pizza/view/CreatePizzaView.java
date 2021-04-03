package com.peregud.pizza.view;

public interface CreatePizzaView {

    void greeting();

    void menuDough();

    void menuIngredients();

    String orderThinDough();

    String orderTraditionalDough();

    String orderCheese();

    String orderMeat();

    String orderSausages();

    String orderOlives();

    String orderTomatoes();

    String orderPepper();

    String orderOregano();

    String orderSauce();

    String orderCrust();

    void displayInfoThinDough();

    void displayInfoTraditionalDough();

    void displayInfoCheese();

    void displayInfoMeat();

    void displayInfoSausages();

    void displayInfoOlives();

    void displayInfoTomatoes();

    void displayInfoPepper();

    void displayInfoOregano();

    void displayInfoSauce();

    void displayInfoCrust();

    void totalCalories(int totalCalories);

    void totalOrder(double totalOrder);

    void addDoughQuestion();

    void addIngredientsQuestion();

    void paymentChoice();

    void doughException();

    void ingredientNumberException();

    void paymentChoiceException();

    void displayOptions();

    void choiceView();

}
