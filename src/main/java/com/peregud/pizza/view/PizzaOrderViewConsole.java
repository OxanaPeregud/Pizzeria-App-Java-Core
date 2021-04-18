package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.exceptions.PizzaNumberException;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.util.*;

import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {
    private static final PizzaNumberException PIZZA_NUMBER_EXCEPTION;
    private static final PaymentChoiceException PAYMENT_CHOICE_EXCEPTION;

    static {
        PIZZA_NUMBER_EXCEPTION = new PizzaNumberException();
        PAYMENT_CHOICE_EXCEPTION = new PaymentChoiceException();
    }

    @Override
    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    @Override
    public void pizzaMenu() {
        System.out.println("1. Four Cheese\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()) + "$");
        System.out.println("2. Margherita\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()) + "$");
        System.out.println("3. Meat Delight\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()) + "$");
        System.out.println("4. Pepperoni\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()) + "$");
        System.out.println("5. Vegetarian\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()) + "$");
    }

    @Override
    public String orderPizzaFourCheese() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()) + "$";
    }

    @Override
    public String orderPizzaMargherita() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()) + "$";
    }

    @Override
    public String orderPizzaMeatDelight() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()) + "$";
    }

    @Override
    public String orderPizzaPepperoni() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()) + "$";
    }

    @Override
    public String orderPizzaVegetarian() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()) + "$";
    }

    @Override
    public void displayInfoPizzaFourCheese() {
        System.out.println("Pizza " + Pizza.FOUR_CHEESE + " Calories: " + PizzaCaloriesUtil.caloriesPizzaFourCheese());
        System.out.println("Ingredients: " + Pizza.FOUR_CHEESE.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaMargherita() {
        System.out.println("Pizza " + Pizza.MARGHERITA + " Calories: " + PizzaCaloriesUtil.caloriesPizzaMargherita());
        System.out.println("Ingredients: " + Pizza.MARGHERITA.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaMeatDelight() {
        System.out.println("Pizza " + Pizza.MEAT_DELIGHT + " Calories: " + PizzaCaloriesUtil.caloriesPizzaMeatDelight());
        System.out.println("Ingredients: " + Pizza.MEAT_DELIGHT.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaPepperoni() {
        System.out.println("Pizza " + Pizza.PEPPERONI + " Calories: " + PizzaCaloriesUtil.caloriesPizzaPepperoni());
        System.out.println("Ingredients: " + Pizza.PEPPERONI.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaVegetarian() {
        System.out.println("Pizza " + Pizza.VEGETARIAN + " Calories: " + PizzaCaloriesUtil.caloriesPizzaVegetarian());
        System.out.println("Ingredients: " + Pizza.VEGETARIAN.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizza() {
        displayInfoPizzaFourCheese();
        displayInfoPizzaMargherita();
        displayInfoPizzaMeatDelight();
        displayInfoPizzaPepperoni();
        displayInfoPizzaVegetarian();
    }

    @Override
    public void totalOrder(double totalOrder, int size) {
        System.out.println("Order is " + RoundUtil.up(totalOrder) + "$\nNumber of pizzas: " + size);
    }

    @Override
    public void discountFor2Pizzas(double totalOrder) {
        System.out.println("Discount for ordering 2 pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForTwoItems(totalOrder)) + "$");
    }

    @Override
    public void discountFor3AndMorePizzas(double totalOrder) {
        System.out.println("Discount for ordering 3 & more pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForThreeAndMoreItems(totalOrder)) + "$");
    }

    @Override
    public void discountForOrderOnSpecificDay(double totalOrder) {
        System.out.println("Discount for ordering on Discount Day: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForOrderOnSpecificDay(totalOrder)) + "$");
    }

    @Override
    public void amountToPay(double totalOrder) {
        System.out.println("Amount to pay: " + RoundUtil.up(totalOrder) + "$");
    }

    @Override
    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    @Override
    public void pizzaNumberException() {
        System.out.println(PIZZA_NUMBER_EXCEPTION.toString());
    }

    @Override
    public void paymentChoiceException() {
        System.out.println(PAYMENT_CHOICE_EXCEPTION.toString());
    }

    @Override
    public void addSupplementIngredients() {
        System.out.println("Press 1 - If you want to add more ingredients to your pizza");
        System.out.println("Press 2 - Continue with original order");
        System.out.println("Press 3 - Pay for the order");
    }

    @Override
    public void displayOptions() {
        System.out.println("Choose what would you like to do:");
        System.out.println("1. Order pizza from our menu");
        System.out.println("2. Display info about pizzas that we have");
        System.out.println("3. Create your own pizza");
        System.out.println("4. Exit");
    }

    @Override
    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 4");
    }
}
