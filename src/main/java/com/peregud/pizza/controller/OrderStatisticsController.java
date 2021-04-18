package com.peregud.pizza.controller;

import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.util.StatisticsUtil;
import com.peregud.pizza.view.OrderStatisticsView;
import com.peregud.pizza.view.OrderStatisticsViewConsole;

public class OrderStatisticsController {
    private static final OrderStatisticsView ORDER_STATISTICS_VIEW;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
    }

    public void displayChoice() {
        SoldPizzasUtil.createMapOfSoldPizzas();
        ORDER_STATISTICS_VIEW.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                StatisticsUtil.displayTotalPizzasSold();
                displayChoice();
                break;
            case 2:
                StatisticsUtil.displayPizzasRevenue();
                displayChoice();
                break;
            case 3:
                StatisticsUtil.displayAverageCheck();
                displayChoice();
                break;
            case 4:
                StatisticsUtil.displayTotalProfit();
                displayChoice();
                break;
            case 5:
                StatisticsUtil.displayProfitMargin();
                displayChoice();
                break;
            case 6:
                StatisticsUtil.displayFullStatistics();
                displayChoice();
                break;
            case 7:
                break;
            default:
                ORDER_STATISTICS_VIEW.choiceView();
                displayChoice();
                break;
        }
    }
}
