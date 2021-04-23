package com.peregud.pizza.controller;

import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.service.StatisticsService;
import com.peregud.pizza.view.OrderStatisticsView;
import com.peregud.pizza.view.OrderStatisticsViewConsole;
import com.peregud.pizza.view.SoldPizzasView;
import com.peregud.pizza.view.SoldPizzasViewConsole;

import java.sql.SQLException;

public class OrderStatisticsController {
    private static final OrderStatisticsView ORDER_STATISTICS_VIEW;
    private static final SoldPizzasView SOLD_PIZZAS_VIEW;
    private static final OrderRepository ORDER_REPOSITORY;
    private static final StatisticsService STATISTICS;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        SOLD_PIZZAS_VIEW = new SoldPizzasViewConsole();
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
        STATISTICS = new StatisticsService();
    }

    public void displayChoice() {
        try {
            SoldPizzasUtil.createMapOfSoldPizzas();
            SoldPizzasUtil.createMapOfPizzasPrices();
            SoldPizzasUtil.createMapOfPizzasCost();
            ORDER_STATISTICS_VIEW.displayChoice();
            int choice = CheckScannerInputUtil.checkInt();
            switch (choice) {
                case 1:
                    STATISTICS.displayTotalPizzasSold();
                    displayChoice();
                    break;
                case 2:
                    STATISTICS.displayPizzasRevenue();
                    displayChoice();
                    break;
                case 3:
                    STATISTICS.displayAverageCheck();
                    displayChoice();
                    break;
                case 4:
                    STATISTICS.displayTotalProfit();
                    displayChoice();
                    break;
                case 5:
                    STATISTICS.displayProfitMargin();
                    displayChoice();
                    break;
                case 6:
                    STATISTICS.displayFullStatistics();
                    displayChoice();
                    break;
                case 7:
                    SOLD_PIZZAS_VIEW.displaySoldPizzas(ORDER_REPOSITORY.getAll());
                    displayChoice();
                    break;
                case 8:
                    break;
                default:
                    ORDER_STATISTICS_VIEW.choiceView();
                    displayChoice();
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
