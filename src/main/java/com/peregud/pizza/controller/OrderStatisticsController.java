package com.peregud.pizza.controller;

import com.peregud.pizza.exceptions.OrderStatisticsException;
import com.peregud.pizza.util.CheckUtil;
import com.peregud.pizza.util.StatisticsUtil;
import com.peregud.pizza.view.OrderStatisticsViewConsole;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class OrderStatisticsController {
    private int numberOfFourCheeseSold;
    private int numberOfMargheritaSold;
    private int numberOfMeatDelightSold;
    private int numberOfPepperoniSold;
    private int numberOfVegetarianSold;
    private static final OrderStatisticsViewConsole ORDER_STATISTICS_VIEW;
    public static final Map<Integer, Integer> SOLD_PIZZAS;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        SOLD_PIZZAS = new HashMap<>();
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            ORDER_STATISTICS_VIEW.enterFourCheese();
            numberOfFourCheeseSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterMargherita();
            numberOfMargheritaSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterMeatDelight();
            numberOfMeatDelightSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterPepperoni();
            numberOfPepperoniSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterVegetarian();
            numberOfVegetarianSold = scan.nextInt();
            createMapOfSoldPizzas();
        } catch (InputMismatchException e) {
            try {
                throw new OrderStatisticsException();
            } catch (OrderStatisticsException ex) {
                ORDER_STATISTICS_VIEW.orderStatisticsException();
                start();
            }
        }
    }

    public void displayChoice() {
        ORDER_STATISTICS_VIEW.displayChoice();
        int choice = CheckUtil.checkInt();
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

    public void createMapOfSoldPizzas() {
        SOLD_PIZZAS.put(1, numberOfFourCheeseSold);
        SOLD_PIZZAS.put(2, numberOfMargheritaSold);
        SOLD_PIZZAS.put(3, numberOfMeatDelightSold);
        SOLD_PIZZAS.put(4, numberOfPepperoniSold);
        SOLD_PIZZAS.put(5, numberOfVegetarianSold);
    }
}
