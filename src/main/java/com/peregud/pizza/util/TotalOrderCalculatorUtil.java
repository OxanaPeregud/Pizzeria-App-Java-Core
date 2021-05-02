package com.peregud.pizza.util;

import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TotalOrderCalculatorUtil {
    private static final CreatePizzaView CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();

    public static void totalOrderPizza() {
        double totalOrder = OrderPizzaUtil.getPizzaOrder().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        int size = OrderPizzaUtil.getPizzaOrder().size();
        OrderPizzaUtil.getPizzaOrderView().totalOrder(totalOrder, size);
    }

    public static void totalOrderIngredient() {
        double totalOrder = OrderPizzaUtil.getPizzaOrder().totalOrder() +
                IngredientOrderUtil.getIngredientOrder().totalOrder();
        CREATE_PIZZA_VIEW.totalOrder(totalOrder);
    }
}
