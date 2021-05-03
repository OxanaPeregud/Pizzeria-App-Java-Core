/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.PizzaNumberException;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.util.OrderPizzaUtil;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.util.HashMap;
import java.util.Map;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> PIZZAS;
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final CreatePizzaService CREATE_PIZZA;

    static {
        PIZZAS = new HashMap<>();
        PIZZAS.put(1, Pizza.FOUR_CHEESE);
        PIZZAS.put(2, Pizza.MARGHERITA);
        PIZZAS.put(3, Pizza.MEAT_DELIGHT);
        PIZZAS.put(4, Pizza.PEPPERONI);
        PIZZAS.put(5, Pizza.VEGETARIAN);

        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        CREATE_PIZZA = new CreatePizzaService();
    }

    public void start() {
        PIZZA_ORDER_VIEW.greeting();
    }

    public void displayOptions() {
        PIZZA_ORDER_VIEW.displayOptions();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                choosePizza();
                break;
            case 2:
                PIZZA_ORDER_VIEW.displayInfoPizza();
                displayOptions();
                break;
            case 3:
                CREATE_PIZZA.start();
                CREATE_PIZZA.chooseDough();
                CREATE_PIZZA.chooseIngredients();
                CREATE_PIZZA.addIngredientsQuestion();
                break;
            case 4:
                break;
            default:
                PIZZA_ORDER_VIEW.choiceView();
                displayOptions();
                break;
        }
    }

    public void choosePizza() {
        PIZZA_ORDER_VIEW.pizzaMenu();
        int choice = CheckScannerInputUtil.checkInt();
        try {
            switch (PIZZAS.get(choice)) {
                case FOUR_CHEESE:
                    OrderPizzaUtil.orderPizza(Pizza.FOUR_CHEESE);
                    break;
                case MARGHERITA:
                    OrderPizzaUtil.orderPizza(Pizza.MARGHERITA);
                    break;
                case MEAT_DELIGHT:
                    OrderPizzaUtil.orderPizza(Pizza.MEAT_DELIGHT);
                    break;
                case PEPPERONI:
                    OrderPizzaUtil.orderPizza(Pizza.PEPPERONI);
                    break;
                case VEGETARIAN:
                    OrderPizzaUtil.orderPizza(Pizza.VEGETARIAN);
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PizzaNumberException();
            } catch (PizzaNumberException ex) {
                ex.printStackTrace();
                PIZZA_ORDER_VIEW.pizzaNumberException();
            }
        }
    }
}
