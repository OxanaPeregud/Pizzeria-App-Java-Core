package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class SoldPizzasUtil {
    private static final Map<Integer, Integer> SOLD_PIZZAS;
    private static final OrderRepository ORDER_REPOSITORY;
    private static final Map<Integer, Double> PIZZAS_PRICES;
    private static final Map<Integer, Double> PIZZAS_COST;

    static {
        SOLD_PIZZAS = new HashMap<>();
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
        PIZZAS_PRICES = new HashMap<>();
        PIZZAS_COST = new HashMap<>();
    }

    private SoldPizzasUtil() {
    }

    public static void createMapOfSoldPizzas() {
        try {
            SOLD_PIZZAS.put(1, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.getAll(),
                    Pizza.FOUR_CHEESE.name()).size());
            SOLD_PIZZAS.put(2, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.getAll(),
                    Pizza.MARGHERITA.name()).size());
            SOLD_PIZZAS.put(3, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.getAll(),
                    Pizza.MEAT_DELIGHT.name()).size());
            SOLD_PIZZAS.put(4, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.getAll(),
                    Pizza.PEPPERONI.name()).size());
            SOLD_PIZZAS.put(5, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.getAll(),
                    Pizza.VEGETARIAN.name()).size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createMapOfPizzasPrices() {
        PIZZAS_PRICES.put(1, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        PIZZAS_PRICES.put(2, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        PIZZAS_PRICES.put(3, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        PIZZAS_PRICES.put(4, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        PIZZAS_PRICES.put(5, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
    }

    public static void createMapOfPizzasCost() {
        PIZZAS_COST.put(1, PizzaCostUtil.costFourCheese());
        PIZZAS_COST.put(2, PizzaCostUtil.costMargherita());
        PIZZAS_COST.put(3, PizzaCostUtil.costMeatDelight());
        PIZZAS_COST.put(4, PizzaCostUtil.costPepperoni());
        PIZZAS_COST.put(5, PizzaCostUtil.costVegetarian());
    }

    public static Map<Integer, Integer> getSoldPizzas() {
        return SOLD_PIZZAS;
    }

    public static Map<Integer, Double> getPizzasPrices() {
        return PIZZAS_PRICES;
    }

    public static Map<Integer, Double> getPizzasCost() {
        return PIZZAS_COST;
    }
}
