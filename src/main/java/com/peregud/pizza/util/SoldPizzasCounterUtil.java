package com.peregud.pizza.util;

import com.peregud.pizza.model.Order;

import java.util.ArrayList;
import java.util.List;

public final class SoldPizzasCounterUtil {

    private SoldPizzasCounterUtil() {
    }

    public static List<Order> soldPizzas(List<Order> list, String pizzaName) {
        List<Order> listOfSpecificPizzas = new ArrayList<>();
        if (list != null) {
            for (Order order : list) {
                if (order.getPizza().equals(pizzaName)) {
                    listOfSpecificPizzas.add(order);
                }
            }
        }
        return listOfSpecificPizzas;
    }
}
