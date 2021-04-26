package com.peregud.pizza.util;

import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Order;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.service.PizzaOrderCalculatorService;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class OrderPizzaUtil {
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final List<Order> ORDER_LIST;
    private static final Order ORDER;
    private static final PizzaOrderCalculatorService PIZZA_ORDER;

    static {
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        ORDER_LIST = new ArrayList<>();
        ORDER = new Order();
        PIZZA_ORDER = new PizzaOrderCalculatorService(new ArrayList<>());
    }

    private OrderPizzaUtil() {
    }

    public static void addToOrder(String pizzaName, double price) {
        getOrderList().add(ORDER.add(pizzaName, RoundUtil.up(price),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
    }

    public static void orderPizza(Pizza pizza) {
        PIZZA_ORDER_VIEW.orderPizza(pizza, PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
        CookUtil.cookPizza(pizza);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(pizza, PizzaPriceUtil.pizzaPriceIncludingVAT(pizza)));
        addToOrder(pizza.name(), PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
        PIZZA_ORDER.add(PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
        TotalOrderCalculatorUtil.totalOrderPizza();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static PizzaOrderView getPizzaOrderView() {
        return PIZZA_ORDER_VIEW;
    }

    public static List<Order> getOrderList() {
        return ORDER_LIST;
    }

    public static PizzaOrderCalculatorService getPizzaOrder() {
        return PIZZA_ORDER;
    }
}
