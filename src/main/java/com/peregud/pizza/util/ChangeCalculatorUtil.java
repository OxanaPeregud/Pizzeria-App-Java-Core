/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ChangeCalculatorUtil {

    public double getChange() {
        return CashPaymentUtil.countChange(OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder());
    }
}
