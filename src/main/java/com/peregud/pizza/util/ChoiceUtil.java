package com.peregud.pizza.util;

import com.peregud.pizza.service.IngredientSupplementService;
import com.peregud.pizza.service.PizzaOrderService;

import java.io.IOException;
import java.util.Scanner;

public class ChoiceUtil {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final IngredientSupplementService INGREDIENT_SUPPLEMENT;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        INGREDIENT_SUPPLEMENT = new IngredientSupplementService();
    }

    public static void addChoiceQuestion() throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            INGREDIENT_SUPPLEMENT.chooseIngredients();
        } else if (choice == 2) {
            PIZZA_ORDER.choosePizza();
        } else if (choice == 3) {
            PIZZA_ORDER.paymentChoice();
        } else {
            System.out.println("You need to enter a number from 1 to 3");
            addChoiceQuestion();
        }
    }
}
