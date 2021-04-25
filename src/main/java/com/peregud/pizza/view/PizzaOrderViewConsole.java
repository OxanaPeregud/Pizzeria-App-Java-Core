package com.peregud.pizza.view;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.util.*;

import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {

    @Override
    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    @Override
    public void pizzaMenu() {
        System.out.println("1. Four Cheese\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE)) + "$");
        System.out.println("2. Margherita\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA)) + "$");
        System.out.println("3. Meat Delight\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT)) + "$");
        System.out.println("4. Pepperoni\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI)) + "$");
        System.out.println("5. Vegetarian\tPrice: " + RoundUtil.up(
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN)) + "$");
    }

    @Override
    public String orderPizza(Pizza pizza, double price) {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + pizza +
                "\t" + RoundUtil.up(price) + "$";
    }

    @Override
    public void displayInfoPizzaFourCheese() {
        System.out.println("Pizza " + Pizza.FOUR_CHEESE + " Calories: " + PizzaCaloriesUtil.caloriesPizzaFourCheese());
        System.out.println("Ingredients: " + Pizza.FOUR_CHEESE.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE)) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaMargherita() {
        System.out.println("Pizza " + Pizza.MARGHERITA + " Calories: " + PizzaCaloriesUtil.caloriesPizzaMargherita());
        System.out.println("Ingredients: " + Pizza.MARGHERITA.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA)) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaMeatDelight() {
        System.out.println("Pizza " + Pizza.MEAT_DELIGHT + " Calories: " + PizzaCaloriesUtil.caloriesPizzaMeatDelight());
        System.out.println("Ingredients: " + Pizza.MEAT_DELIGHT.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT)) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaPepperoni() {
        System.out.println("Pizza " + Pizza.PEPPERONI + " Calories: " + PizzaCaloriesUtil.caloriesPizzaPepperoni());
        System.out.println("Ingredients: " + Pizza.PEPPERONI.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI)) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizzaVegetarian() {
        System.out.println("Pizza " + Pizza.VEGETARIAN + " Calories: " + PizzaCaloriesUtil.caloriesPizzaVegetarian());
        System.out.println("Ingredients: " + Pizza.VEGETARIAN.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN)) + "$");
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
    public void pizzaNumberException() {
        System.out.println("We don't have a pizza under entered number");
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
