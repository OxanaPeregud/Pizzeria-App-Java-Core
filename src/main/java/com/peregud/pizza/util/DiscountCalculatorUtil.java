package com.peregud.pizza.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public final class DiscountCalculatorUtil {

    private DiscountCalculatorUtil() {
    }

    public static void discountForTwoItems() {
        if (OrderPizzaUtil.getPizzaOrder().size() == 2) {
            double totalOrder = DiscountUtil.discountForTwoItems(OrderPizzaUtil.getPizzaOrder().totalOrder());
            OrderPizzaUtil.getPizzaOrderView().discountFor2Pizzas(totalOrder);
        }
    }

    public static void discountForThreeAndMoreItems() {
        if (OrderPizzaUtil.getPizzaOrder().size() >= 3) {
            double totalOrder = DiscountUtil.discountForThreeAndMoreItems(OrderPizzaUtil.getPizzaOrder().totalOrder());
            OrderPizzaUtil.getPizzaOrderView().discountFor3AndMorePizzas(totalOrder);
        }
    }

    public static void discountForOrderOnSpecificDay() {
        if (OrderPizzaUtil.getPizzaOrder().size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(OrderPizzaUtil.getPizzaOrder().totalOrder()) +
                    IngredientOrderUtil.getIngredientOrder().totalOrder();
            OrderPizzaUtil.getPizzaOrderView().discountForOrderOnSpecificDay(totalOrder);
            OrderPizzaUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForOrderOnSpecificDay(
                    OrderPizzaUtil.getPizzaOrder().totalOrder()) + IngredientOrderUtil.getIngredientOrder().totalOrder());
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(OrderPizzaUtil.getPizzaOrder().totalOrder()) +
                    IngredientOrderUtil.getIngredientOrder().totalOrder();
            OrderPizzaUtil.getPizzaOrderView().discountForOrderOnSpecificDay(totalOrder);
        }
    }
}
