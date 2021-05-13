/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TotalOrderCalculatorUtil {

    public double totalOrder(double pizzaOrder, double ingredientOrder) {
        double totalOrder = pizzaOrder + ingredientOrder;
        OrderPizzaUtil.getPIZZA_ORDER_VIEW().totalOrder(totalOrder);
        return totalOrder;
    }
}
