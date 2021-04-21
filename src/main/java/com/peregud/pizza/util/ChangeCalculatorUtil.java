package com.peregud.pizza.util;

public final class ChangeCalculatorUtil {

    private ChangeCalculatorUtil() {
    }

    public static double getChange() {
        return CashPaymentUtil.countChange(OrderPizzaUtil.getPizzaOrder().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder());
    }
}
