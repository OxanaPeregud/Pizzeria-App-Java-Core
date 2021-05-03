/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQLImpl;
import com.peregud.pizza.service.IngredientSupplementService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.view.CheckView;
import com.peregud.pizza.view.CheckViewConsole;
import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ChoiceUtil {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final IngredientSupplementService INGREDIENT_SUPPLEMENT;
    private static final UtilView UTIL_VIEW;
    private static final CheckView CHECK_VIEW;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        INGREDIENT_SUPPLEMENT = new IngredientSupplementService();
        UTIL_VIEW = new UtilViewConsole();
        CHECK_VIEW = new CheckViewConsole();
    }

    public static void addChoiceQuestion() {
        try {
            int choice = CheckScannerInputUtil.checkInt();
            if (choice == 1) {
                INGREDIENT_SUPPLEMENT.chooseIngredients();
            } else if (choice == 2) {
                PIZZA_ORDER.choosePizza();
            } else if (choice == 3) {
                CHECK_VIEW.displayCheck();
                TotalOrderCalculatorUtil.totalOrderPizza();
                PaymentChoiceUtil.paymentChoice();
            } else {
                UTIL_VIEW.choiceUtilView();
                addChoiceQuestion();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
