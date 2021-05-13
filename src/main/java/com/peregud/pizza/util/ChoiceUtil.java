/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.service.IngredientSupplementService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.view.CheckView;
import com.peregud.pizza.view.CheckViewConsole;
import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class ChoiceUtil {
    private final PizzaOrderService PIZZA_ORDER = new PizzaOrderService();
    private final IngredientSupplementService INGREDIENT_SUPPLEMENT = new IngredientSupplementService();
    private final UtilView UTIL_VIEW = new UtilViewConsole();
    private final CheckView CHECK_VIEW = new CheckViewConsole();

    public void addChoiceQuestion() {
        try {
            int choice = CheckScannerInputUtil.checkInt();
            if (choice == 1) {
                INGREDIENT_SUPPLEMENT.chooseIngredients();
            } else if (choice == 2) {
                PIZZA_ORDER.choosePizza();
            } else if (choice == 3) {
                CHECK_VIEW.displayCheck();
                TotalOrderCalculatorUtil.totalOrder(OrderPizzaUtil.getPIZZA_ORDER().totalOrder(),
                        IngredientOrderUtil.getIngredientOrder().totalOrder());
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
