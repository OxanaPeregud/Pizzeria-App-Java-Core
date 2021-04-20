package com.peregud.pizza.view;

import com.peregud.pizza.service.OrderStatisticsService;
import com.peregud.pizza.util.RoundUtil;
import com.peregud.pizza.util.SoldPizzasUtil;

public class OrderStatisticsViewConsole implements OrderStatisticsView {
    private static final OrderStatisticsService ORDER_STATISTICS;

    static {
        ORDER_STATISTICS = new OrderStatisticsService();
    }

    @Override
    public void enterFourCheese() {
        System.out.println("Enter number of Pizzas 'Four Cheese' sold:");
    }

    @Override
    public void enterMargherita() {
        System.out.println("Enter number of Pizzas 'Margherita' sold:");
    }

    @Override
    public void enterMeatDelight() {
        System.out.println("Enter number of Pizzas 'Meat Delight' sold:");
    }

    @Override
    public void enterPepperoni() {
        System.out.println("Enter number of Pizzas 'Pepperoni' sold:");
    }

    @Override
    public void enterVegetarian() {
        System.out.println("Enter number of Pizzas 'Vegetarian' sold:");
    }

    @Override
    public void orderStatisticsException() {
        System.out.println("Number of sold pizzas must to be an integer");
    }

    @Override
    public void pizzasSold() {
        System.out.println("Sold Pizzas 'Four Cheese': " +
                ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()).get(0));
        System.out.println("Sold Pizzas 'Margherita': " +
                ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()).get(1));
        System.out.println("Sold Pizzas 'Meat Delight': " +
                ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()).get(2));
        System.out.println("Sold Pizzas 'Pepperoni': " +
                ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()).get(3));
        System.out.println("Sold Pizzas 'Vegetarian': " +
                ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()).get(4));
    }

    @Override
    public void totalPizzasSold() {
        System.out.println("Total pizzas sold: " + ORDER_STATISTICS.totalSold(SoldPizzasUtil.getSoldPizzas()));
        System.out.println();
    }

    @Override
    public void pizzasRevenue() {
        System.out.println("Revenue from Pizzas 'Four Cheese': " +
                RoundUtil.up(ORDER_STATISTICS.revenue(ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        ORDER_STATISTICS.prices(SoldPizzasUtil.getPizzasPrices())).get(0)) + "$");
        System.out.println("Revenue from Pizzas 'Margherita': " +
                RoundUtil.up(ORDER_STATISTICS.revenue(ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        ORDER_STATISTICS.prices(SoldPizzasUtil.getPizzasPrices())).get(1)) + "$");
        System.out.println("Revenue from Pizzas 'Meat Delight': " +
                RoundUtil.up(ORDER_STATISTICS.revenue(ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        ORDER_STATISTICS.prices(SoldPizzasUtil.getPizzasPrices())).get(2)) + "$");
        System.out.println("Revenue from Pizzas 'Pepperoni': " +
                RoundUtil.up(ORDER_STATISTICS.revenue(ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        ORDER_STATISTICS.prices(SoldPizzasUtil.getPizzasPrices())).get(3)) + "$");
        System.out.println("Revenue from Pizzas 'Vegetarian': " +
                RoundUtil.up(ORDER_STATISTICS.revenue(ORDER_STATISTICS.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        ORDER_STATISTICS.prices(SoldPizzasUtil.getPizzasPrices())).get(4)) + "$");
    }

    @Override
    public void totalRevenue() {
        System.out.println("Total revenue is " + ORDER_STATISTICS.totalRevenue(
                SoldPizzasUtil.getSoldPizzas(), SoldPizzasUtil.getPizzasPrices()) + "$");
        System.out.println();
    }

    @Override
    public void averageCheck() {
        System.out.println("Average check is " + ORDER_STATISTICS.averageCheck(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices()) + "$");
    }

    @Override
    public void totalProfit() {
        System.out.println("Total profit is " + ORDER_STATISTICS.totalProfit(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices(), SoldPizzasUtil.getPizzasCost()) + "$");
    }

    @Override
    public void profitMargin() {
        System.out.println("Profit margin is " + ORDER_STATISTICS.profitMargin(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices(), SoldPizzasUtil.getPizzasCost()) + "%");
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
        System.out.println("8. Exit");
    }

    @Override
    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 8");
    }
}
