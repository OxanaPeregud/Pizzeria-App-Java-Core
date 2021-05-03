/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SoldPizzasUtil {
    @Getter
    private static final Map<Integer, Integer> SOLD_PIZZAS;
    private static final OrderRepository ORDER_REPOSITORY;
    @Getter
    private static final Map<Integer, Double> PIZZAS_PRICES;
    @Getter
    private static final Map<Integer, Double> PIZZAS_COST;

    static {
        SOLD_PIZZAS = new HashMap<>();
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
        PIZZAS_PRICES = new HashMap<>();
        PIZZAS_COST = new HashMap<>();
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
        PIZZAS_PRICES.put(1, PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE));
        PIZZAS_PRICES.put(2, PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA));
        PIZZAS_PRICES.put(3, PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT));
        PIZZAS_PRICES.put(4, PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI));
        PIZZAS_PRICES.put(5, PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN));
    }

    public static void createMapOfPizzasCost() {
        PIZZAS_COST.put(1, PizzaCostUtil.pizzaCost(Pizza.FOUR_CHEESE));
        PIZZAS_COST.put(2, PizzaCostUtil.pizzaCost(Pizza.MARGHERITA));
        PIZZAS_COST.put(3, PizzaCostUtil.pizzaCost(Pizza.MEAT_DELIGHT));
        PIZZAS_COST.put(4, PizzaCostUtil.pizzaCost(Pizza.PEPPERONI));
        PIZZAS_COST.put(5, PizzaCostUtil.pizzaCost(Pizza.VEGETARIAN));
    }
}
