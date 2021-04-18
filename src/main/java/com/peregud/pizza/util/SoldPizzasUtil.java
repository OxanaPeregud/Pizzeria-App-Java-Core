package com.peregud.pizza.util;

import com.peregud.pizza.service.SoldPizzasCounterService;
import com.peregud.pizza.service.SoldPizzasCounterServiceSQL;

import java.util.HashMap;
import java.util.Map;

public final class SoldPizzasUtil {
    private static final Map<Integer, Integer> SOLD_PIZZAS;
    private static final SoldPizzasCounterService SOLD_PIZZAS_COUNTER;

    static {
        SOLD_PIZZAS = new HashMap<>();
        SOLD_PIZZAS_COUNTER = new SoldPizzasCounterServiceSQL();
    }

    private SoldPizzasUtil() {
    }

    public static void createMapOfSoldPizzas() {
        SOLD_PIZZAS.put(1, SOLD_PIZZAS_COUNTER.countPizzasFourCheese().size());
        SOLD_PIZZAS.put(2, SOLD_PIZZAS_COUNTER.countPizzasMargherita().size());
        SOLD_PIZZAS.put(3, SOLD_PIZZAS_COUNTER.countPizzasMeatDelight().size());
        SOLD_PIZZAS.put(4, SOLD_PIZZAS_COUNTER.countPizzasPepperoni().size());
        SOLD_PIZZAS.put(5, SOLD_PIZZAS_COUNTER.countPizzasVegetarian().size());
    }

    public static Map<Integer, Integer> getSoldPizzas() {
        return SOLD_PIZZAS;
    }
}
