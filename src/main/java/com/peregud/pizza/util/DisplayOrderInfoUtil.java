package com.peregud.pizza.util;

public final class DisplayOrderInfoUtil {

    private DisplayOrderInfoUtil() {
    }

    public static void showOrderInfo() {
        TotalOrderCalculatorUtil.totalOrder();
        DiscountCalculatorUtil.discountForTwoItems();
        DiscountCalculatorUtil.discountForThreeAndMoreItems();
        DiscountCalculatorUtil.discountForOrderOnSpecificDay();
        AmountToPayCalculatorUtil.amountToPay(OrderPizzaUtil.getPizzaOrder().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder());
    }
}
