/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.util.RoundUtil;

import java.util.List;

public class OrderStatisticsViewConsole implements OrderStatisticsView {

    @Override
    public void pizzasSold(Pizza pizza, List<Integer> soldItems, int index) {
        System.out.println("Sold Pizzas " + pizza + ": " + soldItems.get(index));
    }

    @Override
    public void totalPizzasSold(int soldItems) {
        System.out.println("Total pizzas sold: " + soldItems);
        System.out.println();
    }

    @Override
    public void pizzasRevenue(Pizza pizza, List<Double> revenue, int index) {
        System.out.println("Revenue from Pizzas " + pizza + ": " + RoundUtil.up(revenue.get(index)) + "$");
    }

    @Override
    public void totalRevenue(double revenue) {
        System.out.println("Total revenue is " + revenue + "$");
        System.out.println();
    }

    @Override
    public void averageCheck(double averageCheck) {
        System.out.println("Average check is " + averageCheck + "$");
    }

    @Override
    public void totalProfit(double totalProfit) {
        System.out.println("Total profit is " + totalProfit + "$");
    }

    @Override
    public void profitMargin(double profitMargin) {
        System.out.println("Profit margin is " + profitMargin + "%");
    }

    @Override
    public void displayChoice() {
        System.out.println("Choose what statistics would you like to display:");
        System.out.println("1. Total pizzas sold");
        System.out.println("2. Pizzas revenue");
        System.out.println("3. Average check");
        System.out.println("4. Total profit");
        System.out.println("5. Profit margin");
        System.out.println("6. Full order statistics");
        System.out.println("7. Display all sold pizzas");
        System.out.println("8. Exit statistics");
    }

    @Override
    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 8");
    }
}
