/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.dao.DAOOrder;
import com.peregud.pizza.dao.impl.DAOOrderSQLImpl;
import com.peregud.pizza.model.Order;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.service.PizzaOrderCalculatorService;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class OrderPizzaUtil {
    @Getter
    private final PizzaOrderView PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
    private final Order ORDER = new Order();
    @Getter
    private final PizzaOrderCalculatorService PIZZA_ORDER = new PizzaOrderCalculatorService(new ArrayList<>());
    private final DAOOrder DAO_ORDER = new DAOOrderSQLImpl();
    @Getter
    private final List<Integer> ORDER_ID = new ArrayList<>();

    public void addToOrder(String pizzaName, double price) {
        try {
            DAO_ORDER.save(ORDER.add(pizzaName, RoundUtil.up(price),
                    DateFormatUtil.localDatePattern(LocalDateTime.now())));
            ORDER_ID.add(DAO_ORDER.getAll().size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void orderPizza(Pizza pizza) {
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
