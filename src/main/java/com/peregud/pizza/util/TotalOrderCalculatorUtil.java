/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TotalOrderCalculatorUtil {
    private final CreatePizzaView CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();

    public void totalOrderPizza() {
        double totalOrder = OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        int size = OrderPizzaUtil.getPIZZA_ORDER().size();
        OrderPizzaUtil.getPIZZA_ORDER_VIEW().totalOrder(totalOrder, size);
    }

    public void totalOrderIngredient() {
        double totalOrder = OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        CREATE_PIZZA_VIEW.totalOrder(totalOrder);
    }
}
