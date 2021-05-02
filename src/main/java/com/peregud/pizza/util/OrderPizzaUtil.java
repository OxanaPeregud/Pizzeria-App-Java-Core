package com.peregud.pizza.util;

import com.peregud.pizza.model.Order;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import com.peregud.pizza.service.PizzaOrderCalculatorService;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrderPizzaUtil {
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final Order ORDER;
    private static final PizzaOrderCalculatorService PIZZA_ORDER;
    private static final OrderRepository ORDER_REPOSITORY;

    static {
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        ORDER = new Order();
        PIZZA_ORDER = new PizzaOrderCalculatorService(new ArrayList<>());
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
    }

    public static void addToOrder(String pizzaName, double price) {
        try {
            ORDER_REPOSITORY.save(ORDER.add(pizzaName, RoundUtil.up(price),
                    DateFormatUtil.localDatePattern(LocalDateTime.now())));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void orderPizza(Pizza pizza) {
        try {
            PIZZA_ORDER_VIEW.orderPizza(pizza, PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
            CookUtil.cookPizza(pizza);
            CheckUtil.add(PIZZA_ORDER_VIEW.orderPizza(pizza, PizzaPriceUtil.pizzaPriceIncludingVAT(pizza)));
            addToOrder(pizza.name(), PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
            PIZZA_ORDER.add(PizzaPriceUtil.pizzaPriceIncludingVAT(pizza));
            TotalOrderCalculatorUtil.totalOrderPizza();
            PIZZA_ORDER_VIEW.addSupplementIngredients();
            ChoiceUtil.addChoiceQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PizzaOrderView getPizzaOrderView() {
        return PIZZA_ORDER_VIEW;
    }

    public static PizzaOrderCalculatorService getPizzaOrder() {
        return PIZZA_ORDER;
    }
}
