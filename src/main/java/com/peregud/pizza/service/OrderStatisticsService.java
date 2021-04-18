package com.peregud.pizza.service;

import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStatisticsService {
    private static final Map<Integer, Double> PIZZAS_PRICES;
    private static final Map<Integer, Double> PIZZAS_COST;
    private static final List<Double> PIZZAS_REVENUE;

    static {
        PIZZAS_PRICES = new HashMap<>();
        PIZZAS_PRICES.put(1, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        PIZZAS_PRICES.put(2, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        PIZZAS_PRICES.put(3, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        PIZZAS_PRICES.put(4, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        PIZZAS_PRICES.put(5, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());

        PIZZAS_COST = new HashMap<>();
        PIZZAS_COST.put(1, PizzaCostUtil.costFourCheese());
        PIZZAS_COST.put(2, PizzaCostUtil.costMargherita());
        PIZZAS_COST.put(3, PizzaCostUtil.costMeatDelight());
        PIZZAS_COST.put(4, PizzaCostUtil.costPepperoni());
        PIZZAS_COST.put(5, PizzaCostUtil.costVegetarian());

        PIZZAS_REVENUE = new ArrayList<>();
    }

    public List<Integer> pizzasSold() {
        return new ArrayList<>(SoldPizzasUtil.getSoldPizzas()
                .values());
    }

    public int totalPizzasSold() {
        return SoldPizzasUtil.getSoldPizzas()
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public List<Double> pizzasPrices() {
        return new ArrayList<>(PIZZAS_PRICES
                .values());
    }

    public List<Double> pizzasRevenue() {
        for (int i = 0; i < pizzasSold().size(); i++) {
            PIZZAS_REVENUE.add(pizzasSold().get(i) * pizzasPrices().get(i));
        }
        return new ArrayList<>(PIZZAS_REVENUE);
    }

    public double totalRevenue() {
        double sum = 0;
        for (Integer key : SoldPizzasUtil.getSoldPizzas().keySet()) {
            double value1 = SoldPizzasUtil.getSoldPizzas().get(key);
            double value2 = PIZZAS_PRICES.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double averageCheck() {
        return RoundUtil.up(totalRevenue() / totalPizzasSold());
    }

    public double totalCost() {
        double sum = 0;
        for (Integer key : SoldPizzasUtil.getSoldPizzas().keySet()) {
            double value1 = SoldPizzasUtil.getSoldPizzas().get(key);
            double value2 = PIZZAS_COST.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double totalProfit() {
        return RoundUtil.up(TaxUtil.CorporateIncomeTax(totalRevenue() -
                TaxUtil.VATonRevenue(totalRevenue()) - totalCost()));
    }

    public double profitMargin() {
        return RoundUtil.up(totalProfit() / totalRevenue() * 100);
    }
}
