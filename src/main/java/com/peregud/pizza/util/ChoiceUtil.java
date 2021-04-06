package com.peregud.pizza.util;

import com.peregud.pizza.service.IngredientSupplementService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;

import java.io.IOException;

public final class ChoiceUtil {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final IngredientSupplementService INGREDIENT_SUPPLEMENT;
    private static final UtilView UTIL_VIEW;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        INGREDIENT_SUPPLEMENT = new IngredientSupplementService();
        UTIL_VIEW = new UtilViewConsole();
    }

    private ChoiceUtil() {
    }

    public static void addChoiceQuestion() throws IOException {
        int choice = CheckUtil.checkInt();
        if (choice == 1) {
            INGREDIENT_SUPPLEMENT.chooseIngredients();
        } else if (choice == 2) {
            PIZZA_ORDER.choosePizza();
        } else if (choice == 3) {
            PIZZA_ORDER.paymentChoice();
        } else {
            UTIL_VIEW.choiceUtilView();
            addChoiceQuestion();
        }
    }
}
