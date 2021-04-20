package com.peregud.pizza.service;

import com.peregud.pizza.util.OrderStatisticsUtil;
import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.view.OrderStatisticsView;
import com.peregud.pizza.view.OrderStatisticsViewConsole;

public class StatisticsService {
    private static final OrderStatisticsView ORDER_STATISTICS_VIEW;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
    }

    public void displayTotalPizzasSold() {
        OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas());
        ORDER_STATISTICS_VIEW.pizzasSold();
        OrderStatisticsUtil.totalSold(SoldPizzasUtil.getSoldPizzas());
        ORDER_STATISTICS_VIEW.totalPizzasSold();
    }

    public void displayPizzasRevenue() {
        OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices()));
        ORDER_STATISTICS_VIEW.pizzasRevenue();
        OrderStatisticsUtil.totalRevenue(SoldPizzasUtil.getSoldPizzas(), SoldPizzasUtil.getPizzasPrices());
        ORDER_STATISTICS_VIEW.totalRevenue();
    }

    public void displayAverageCheck() {
        OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSoldPizzas(), SoldPizzasUtil.getPizzasPrices());
        ORDER_STATISTICS_VIEW.averageCheck();
    }

    public void displayTotalProfit() {
        OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSoldPizzas(), SoldPizzasUtil.getPizzasPrices(),
                SoldPizzasUtil.getPizzasCost());
        ORDER_STATISTICS_VIEW.totalProfit();
    }

    public void displayProfitMargin() {
        OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSoldPizzas(), SoldPizzasUtil.getPizzasPrices(),
                SoldPizzasUtil.getPizzasCost());
        ORDER_STATISTICS_VIEW.profitMargin();
    }

    public void displayFullStatistics() {
        displayTotalPizzasSold();
        displayPizzasRevenue();
        displayAverageCheck();
        displayTotalProfit();
        displayProfitMargin();
    }
}
