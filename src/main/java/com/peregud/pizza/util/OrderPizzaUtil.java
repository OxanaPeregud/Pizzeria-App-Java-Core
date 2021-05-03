/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Order;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import com.peregud.pizza.service.PizzaOrderCalculatorService;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderPizzaUtil {
    @Getter
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final Order ORDER;
    @Getter
    private static final PizzaOrderCalculatorService PIZZA_ORDER;
    private static final OrderRepository ORDER_REPOSITORY;
    @Getter
    private static final List<Integer> ORDER_ID;

    static {
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        ORDER = new Order();
        PIZZA_ORDER = new PizzaOrderCalculatorService(new ArrayList<>());
        ORDER_REPOSITORY = new OrderRepositorySQLImpl();
        ORDER_ID = new ArrayList<>();
    }

    public static void addToOrder(String pizzaName, double price) {
        try {
            ORDER_REPOSITORY.save(ORDER.add(pizzaName, RoundUtil.up(price),
                    DateFormatUtil.localDatePattern(LocalDateTime.now())));
            ORDER_ID.add(ORDER_REPOSITORY.getAll().size());
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
}
