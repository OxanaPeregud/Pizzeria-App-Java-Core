/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SoldPizzasCounterUtil {

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
