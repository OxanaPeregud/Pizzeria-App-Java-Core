package com.peregud.pizza.util;

import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQL;
import com.peregud.pizza.service.IngredientSupplementService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;

import java.io.IOException;

public final class ChoiceUtil {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final IngredientSupplementService INGREDIENT_SUPPLEMENT;
    private static final UtilView UTIL_VIEW;
    private static final OrderRepository ORDER_REPOSITORY;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        INGREDIENT_SUPPLEMENT = new IngredientSupplementService();
        UTIL_VIEW = new UtilViewConsole();
        ORDER_REPOSITORY = new OrderRepositorySQL();
    }

    private ChoiceUtil() {
    }

    public static void addChoiceQuestion() {
        try {
            int choice = CheckScannerInputUtil.checkInt();
            if (choice == 1) {
                INGREDIENT_SUPPLEMENT.chooseIngredients();
            } else if (choice == 2) {
                PIZZA_ORDER.choosePizza();
            } else if (choice == 3) {
                ORDER_REPOSITORY.orderInput(OrderPizzaUtil.getOrderList());
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
