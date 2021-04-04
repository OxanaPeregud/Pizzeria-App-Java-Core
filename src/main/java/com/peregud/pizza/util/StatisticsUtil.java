package com.peregud.pizza.util;

import com.peregud.pizza.service.OrderStatisticsService;
import com.peregud.pizza.view.OrderStatisticsViewConsole;

public final class StatisticsUtil {
    private static final OrderStatisticsViewConsole ORDER_STATISTICS_VIEW;
    private static final OrderStatisticsService ORDER_STATISTICS;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        ORDER_STATISTICS = new OrderStatisticsService();
    }

    private StatisticsUtil() {
    }

    public static void displayTotalPizzasSold() {
        ORDER_STATISTICS.pizzasSold();
        ORDER_STATISTICS_VIEW.pizzasSold();
        ORDER_STATISTICS.totalPizzasSold();
        ORDER_STATISTICS_VIEW.totalPizzasSold();
    }

    public static void displayPizzasRevenue() {
        ORDER_STATISTICS.pizzasRevenue();
        ORDER_STATISTICS_VIEW.pizzasRevenue();
        ORDER_STATISTICS.totalRevenue();
        ORDER_STATISTICS_VIEW.totalRevenue();
    }

    public static void displayAverageCheck() {
        ORDER_STATISTICS.averageCheck();
        ORDER_STATISTICS_VIEW.averageCheck();
    }

    public static void displayTotalProfit() {
        ORDER_STATISTICS.totalProfit();
        ORDER_STATISTICS_VIEW.totalProfit();
    }

    public static void displayProfitMargin() {
        ORDER_STATISTICS.profitMargin();
        ORDER_STATISTICS_VIEW.profitMargin();
    }

    public static void displayFullStatistics() {
        displayTotalPizzasSold();
        displayPizzasRevenue();
        displayAverageCheck();
        displayTotalProfit();
        displayProfitMargin();
    }
}
