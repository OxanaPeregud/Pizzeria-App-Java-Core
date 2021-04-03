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

    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    public void pizzaMenu() {
        System.out.println("1. Four Cheese");
        System.out.println("2. Margherita");
        System.out.println("3. Meat Delight");
        System.out.println("4. Pepperoni");
        System.out.println("5. Vegetarian");
    }

    public String orderPizzaFourCheese() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()) + "$";
    }

    public String orderPizzaMargherita() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()) + "$";
    }

    public String orderPizzaMeatDelight() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()) + "$";
    }

    public String orderPizzaPepperoni() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()) + "$";
    }

    public String orderPizzaVegetarian() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()) + "$";
    }

    public void displayInfoPizzaFourCheese() {
        System.out.println("Pizza " + Pizza.FOUR_CHEESE + " Calories: " +
                PizzaCaloriesUtil.caloriesPizzaFourCheese() +
                ", Ingredients: " + Pizza.FOUR_CHEESE.getIngredients());
    }

    public void displayInfoPizzaMargherita() {
        System.out.println("Pizza " + Pizza.MARGHERITA + " Calories: " +
                PizzaCaloriesUtil.caloriesPizzaMargherita() +
                ", Ingredients: " + Pizza.MARGHERITA.getIngredients());
    }

    public void displayInfoPizzaMeatDelight() {
        System.out.println("Pizza " + Pizza.MEAT_DELIGHT + " Calories: " +
                PizzaCaloriesUtil.caloriesPizzaMeatDelight() +
                ", Ingredients: " + Pizza.MEAT_DELIGHT.getIngredients());
    }

    public void displayInfoPizzaPepperoni() {
        System.out.println("Pizza " + Pizza.PEPPERONI + " Calories: " +
                PizzaCaloriesUtil.caloriesPizzaPepperoni() +
                ", Ingredients: " + Pizza.PEPPERONI.getIngredients());
    }

    public void displayInfoPizzaVegetarian() {
        System.out.println("Pizza " + Pizza.VEGETARIAN + " Calories: " +
                PizzaCaloriesUtil.caloriesPizzaVegetarian() +
                ", Ingredients: " + Pizza.VEGETARIAN.getIngredients());
    }

    public void totalOrder(double totalOrder, int size) {
        System.out.println("Order is " + RoundUtil.up(totalOrder) + "$\nNumber of pizzas: " + size);
    }

    public void discountFor2Pizzas(double totalOrder) {
        System.out.println("Discount for ordering 2 pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForTwoItems(totalOrder)) + "$");
    }

    public void discountFor3AndMorePizzas(double totalOrder) {
        System.out.println("Discount for ordering 3 & more pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForThreeAndMoreItems(totalOrder)) + "$");
    }

    public void discountForOrderOnSpecificDay(double totalOrder) {
        System.out.println("Discount for ordering on Discount Day: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForOrderOnSpecificDay(totalOrder)) + "$");
    }

    public void amountToPay(double totalOrder) {
        System.out.println("Amount to pay: " + RoundUtil.up(totalOrder) + "$");
    }

    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    public void pizzaNumberException() {
        System.out.println(PIZZA_NUMBER_EXCEPTION.toString());
    }

    public void paymentChoiceException() {
        System.out.println(PAYMENT_CHOICE_EXCEPTION.toString());
    }

    public void addSupplementIngredients() {
        System.out.println("Press 1 - If you want to add more ingredients to your pizza");
        System.out.println("Press 2 - Continue with original order");
        System.out.println("Press 3 - Pay for the order");
    }

    public void displayOptions() {
        System.out.println("Choose what would you like to do:");
        System.out.println("1. Order pizza from our menu");
        System.out.println("2. Display info about pizzas that we have");
        System.out.println("3. Create your own pizza");
        System.out.println("4. Exit");
    }

    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 4");
    }
}
