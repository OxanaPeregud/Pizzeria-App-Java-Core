package com.peregud.pizza.util;

public final class TotalOrderCalculatorUtil {

    private TotalOrderCalculatorUtil() {
    }

    public static void totalOrder() {
        double totalOrder = OrderPizzaUtil.getPizzaOrder().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        int size = OrderPizzaUtil.getPizzaOrder().size();
        OrderPizzaUtil.getPizzaOrderView().totalOrder(totalOrder, size);
    }
}
