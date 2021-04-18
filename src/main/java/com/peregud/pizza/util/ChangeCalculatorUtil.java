package com.peregud.pizza.util;

public final class ChangeCalculatorUtil {

    private ChangeCalculatorUtil() {
    }

    public static double getChange() {
        return CashPaymentUtil.countChange(AmountToPayCalculatorUtil.amountToPay(OrderPizzaUtil.getPizzaOrder().
                totalOrder() + IngredientOrderUtil.getIngredientOrder().totalOrder()));
    }
}
