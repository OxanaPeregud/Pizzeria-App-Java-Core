package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ChangeCalculatorUtil {

    public static double getChange() {
        return CashPaymentUtil.countChange(OrderPizzaUtil.getPIZZA_ORDER().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder());
    }
}
