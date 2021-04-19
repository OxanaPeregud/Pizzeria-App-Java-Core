package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQL;

import java.util.HashMap;
import java.util.Map;

public final class SoldPizzasUtil {
    private static final Map<Integer, Integer> SOLD_PIZZAS;
    private static final OrderRepository ORDER_REPOSITORY;

    static {
        SOLD_PIZZAS = new HashMap<>();
        ORDER_REPOSITORY = new OrderRepositorySQL();
    }

    private SoldPizzasUtil() {
    }

    public static void createMapOfSoldPizzas() {
        SOLD_PIZZAS.put(1, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.orderOutput(),
                Pizza.FOUR_CHEESE.name()).size());
        SOLD_PIZZAS.put(2, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.orderOutput(),
                Pizza.MARGHERITA.name()).size());
        SOLD_PIZZAS.put(3, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.orderOutput(),
                Pizza.MEAT_DELIGHT.name()).size());
        SOLD_PIZZAS.put(4, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.orderOutput(),
                Pizza.PEPPERONI.name()).size());
        SOLD_PIZZAS.put(5, SoldPizzasCounterUtil.soldPizzas(ORDER_REPOSITORY.orderOutput(),
                Pizza.VEGETARIAN.name()).size());
    }

    public static Map<Integer, Integer> getSoldPizzas() {
        return SOLD_PIZZAS;
    }
}
