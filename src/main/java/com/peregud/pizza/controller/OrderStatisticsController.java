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
    private static final OrderStatisticsView ORDER_STATISTICS_VIEW;
    private static final SoldPizzasView SOLD_PIZZAS_VIEW;
    private static final OrderRepository ORDER_REPOSITORY;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        SOLD_PIZZAS_VIEW = new SoldPizzasViewConsole();
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
    }

    public void start() {
        try {
            SoldPizzasUtil.createMapOfSoldPizzas();
            SoldPizzasUtil.createMapOfPizzasPrices();
            SoldPizzasUtil.createMapOfPizzasCost();
            ORDER_STATISTICS_VIEW.displayChoice();
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
                    ORDER_STATISTICS_VIEW.averageCheck(OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES()));
                    start();
                    break;
                case 4:
                    ORDER_STATISTICS_VIEW.totalProfit(OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 5:
                    ORDER_STATISTICS_VIEW.profitMargin(OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 6:
                    soldPizzasView();
                    soldPizzasRevenue();
                    ORDER_STATISTICS_VIEW.averageCheck(OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES()));
                    ORDER_STATISTICS_VIEW.totalProfit(OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    ORDER_STATISTICS_VIEW.profitMargin(OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSOLD_PIZZAS(),
                            SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
                    start();
                    break;
                case 7:
                    SOLD_PIZZAS_VIEW.displaySoldPizzas(ORDER_REPOSITORY.getAll());
                    start();
                    break;
                case 8:
                    break;
                default:
                    ORDER_STATISTICS_VIEW.choiceView();
                    start();
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void soldPizzasView() {
        ORDER_STATISTICS_VIEW.pizzasSold(Pizza.FOUR_CHEESE,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 0);
        ORDER_STATISTICS_VIEW.pizzasSold(Pizza.MARGHERITA,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 1);
        ORDER_STATISTICS_VIEW.pizzasSold(Pizza.MEAT_DELIGHT,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 2);
        ORDER_STATISTICS_VIEW.pizzasSold(Pizza.PEPPERONI,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 3);
        ORDER_STATISTICS_VIEW.pizzasSold(Pizza.VEGETARIAN,
                OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()), 4);
        ORDER_STATISTICS_VIEW.totalPizzasSold(OrderStatisticsUtil.totalSold(SoldPizzasUtil.getSOLD_PIZZAS()));
    }

    public void soldPizzasRevenue() {
        ORDER_STATISTICS_VIEW.pizzasRevenue(Pizza.FOUR_CHEESE,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 0);
        ORDER_STATISTICS_VIEW.pizzasRevenue(Pizza.MARGHERITA,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 1);
        ORDER_STATISTICS_VIEW.pizzasRevenue(Pizza.MEAT_DELIGHT,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 2);
        ORDER_STATISTICS_VIEW.pizzasRevenue(Pizza.PEPPERONI,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 3);
        ORDER_STATISTICS_VIEW.pizzasRevenue(Pizza.VEGETARIAN,
                OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())), 4);
        ORDER_STATISTICS_VIEW.totalRevenue(OrderStatisticsUtil.totalRevenue(
                SoldPizzasUtil.getSOLD_PIZZAS(), SoldPizzasUtil.getPIZZAS_PRICES()));
    }
}
