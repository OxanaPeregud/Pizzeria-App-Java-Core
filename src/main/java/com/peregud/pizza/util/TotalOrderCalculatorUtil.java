/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TotalOrderCalculatorUtil {
    private static final CreatePizzaView CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();

    public static void totalOrderPizza() {
        double totalOrder = OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        int size = OrderPizzaUtil.getPIZZA_ORDER().size();
        OrderPizzaUtil.getPIZZA_ORDER_VIEW().totalOrder(totalOrder, size);
    }

    public static void totalOrderIngredient() {
        double totalOrder = OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        CREATE_PIZZA_VIEW.totalOrder(totalOrder);
    }
}
