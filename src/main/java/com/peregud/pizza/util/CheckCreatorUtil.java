package com.peregud.pizza.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public final class CheckCreatorUtil {

    private CheckCreatorUtil() {
    }

    public static void createCheck() {
        if (OrderPizzaUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            OrderPizzaUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForTwoItems(OrderPizzaUtil.
                    getPizzaOrder().totalOrder()) + IngredientOrderUtil.getIngredientOrder().totalOrder());
        } else if (OrderPizzaUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            OrderPizzaUtil.getPizzaOrderView().amountToPay(DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    OrderPizzaUtil.getPizzaOrder().totalOrder()) + IngredientOrderUtil.getIngredientOrder().totalOrder());
        } else if (OrderPizzaUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            OrderPizzaUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForThreeAndMoreItems(
                    OrderPizzaUtil.getPizzaOrder().totalOrder()) + IngredientOrderUtil.getIngredientOrder().totalOrder());
        } else if (OrderPizzaUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            OrderPizzaUtil.getPizzaOrderView().amountToPay(DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    OrderPizzaUtil.getPizzaOrder().totalOrder()) + IngredientOrderUtil.getIngredientOrder().totalOrder());
        }
    }
}
