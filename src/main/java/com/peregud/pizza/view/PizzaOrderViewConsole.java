/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

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
        System.out.println("\nChoose pizza from menu:");
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

    public void displayInfoAboutPizza(Pizza pizza) {
        System.out.println("Pizza " + pizza + " Calories: " + PizzaCaloriesUtil.pizzaCalories(pizza));
        System.out.println("Ingredients: " + pizza.getIngredients());
        System.out.println("Price: " + RoundUtil.up(PizzaPriceUtil.pizzaPriceIncludingVAT(pizza)) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPizza() {
        displayInfoAboutPizza(Pizza.FOUR_CHEESE);
        displayInfoAboutPizza(Pizza.MARGHERITA);
        displayInfoAboutPizza(Pizza.MEAT_DELIGHT);
        displayInfoAboutPizza(Pizza.PEPPERONI);
        displayInfoAboutPizza(Pizza.VEGETARIAN);
    }

    @Override
    public void totalOrder(double totalOrder, int size) {
        System.out.println("Total sum of order is " + RoundUtil.up(totalOrder) + "$\nNumber of pizzas: " + size);
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
