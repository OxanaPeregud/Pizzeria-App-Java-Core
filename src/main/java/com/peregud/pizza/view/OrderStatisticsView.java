/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.model.Pizza;

import java.util.List;

public interface OrderStatisticsView {

    void pizzasSold(Pizza pizza, List<Integer> soldItems, int index);

    void totalPizzasSold(int soldItems);

    void pizzasRevenue(Pizza pizza, List<Double> revenue, int index);

    void totalRevenue(double revenue);

    void averageCheck(double averageCheck);

    void totalProfit(double totalProfit);

    void profitMargin(double profitMargin);

    void displayChoice();

    void choiceView();

}
