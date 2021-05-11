/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.controller;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import com.peregud.pizza.util.OrderStatisticsUtil;
import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.OrderStatisticsView;
import com.peregud.pizza.view.OrderStatisticsViewConsole;
import com.peregud.pizza.view.SoldPizzasView;
import com.peregud.pizza.view.SoldPizzasViewConsole;

import java.sql.SQLException;

public class OrderStatisticsController {
    private final OrderStatisticsView orderStatisticsView = new OrderStatisticsViewConsole();
    private final SoldPizzasView soldPizzasView = new SoldPizzasViewConsole();
    private final OrderRepository orderRepository = new OrderRepositorySQLImpl();

    public void start() {
        try {
            SoldPizzasUtil.createMapOfSoldPizzas();
            SoldPizzasUtil.createMapOfPizzasPrices();
            SoldPizzasUtil.createMapOfPizzasCost();
            orderStatisticsView.displayChoice();
            int choice = CheckScannerInputUtil.checkInt();
            switch (choice) {
                case 1:
                    soldPizzasView();
                    start();
                    break;
                case 2:
                    soldPizzasRevenue();
                    start();
                    break;
                case 3:
                    orderStatisticsView.averageCheck(OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES()));
                    start();
                    break;
                case 4:
                    orderStatisticsView.totalProfit(OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 5:
                    orderStatisticsView.profitMargin(OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 6:
                    soldPizzasView();
                    soldPizzasRevenue();
                    orderStatisticsView.averageCheck(OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES()));
                    orderStatisticsView.totalProfit(OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    orderStatisticsView.profitMargin(OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 7:
                    soldPizzasView.displaySoldPizzas(orderRepository.getAll());
                    start();
                    break;
                case 8:
                    break;
                default:
                    orderStatisticsView.choiceView();
                    start();
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void soldPizzasView() {
        orderStatisticsView.pizzasSold(Pizza.FOUR_CHEESE,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 0);
        orderStatisticsView.pizzasSold(Pizza.MARGHERITA,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 1);
        orderStatisticsView.pizzasSold(Pizza.MEAT_DELIGHT,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 2);
        orderStatisticsView.pizzasSold(Pizza.PEPPERONI,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 3);
        orderStatisticsView.pizzasSold(Pizza.VEGETARIAN,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 4);
        orderStatisticsView.totalPizzasSold(OrderStatisticsUtil.totalSold(SoldPizzasUtil.getSOLD_PIZZAS()));
    }

    public void soldPizzasRevenue() {
        orderStatisticsView.pizzasRevenue(Pizza.FOUR_CHEESE,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 0);
        orderStatisticsView.pizzasRevenue(Pizza.MARGHERITA,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 1);
        orderStatisticsView.pizzasRevenue(Pizza.MEAT_DELIGHT,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 2);
        orderStatisticsView.pizzasRevenue(Pizza.PEPPERONI,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 3);
        orderStatisticsView.pizzasRevenue(Pizza.VEGETARIAN,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 4);
        orderStatisticsView.totalRevenue(OrderStatisticsUtil.totalRevenue(
                SoldPizzasUtil.getSOLD_PIZZAS(), SoldPizzasUtil.getPIZZAS_PRICES()));
    }
}
