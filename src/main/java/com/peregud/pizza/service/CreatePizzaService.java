package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.DoughException;
import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaService {
    private static final CreatePizzaView CREATE_PIZZA_VIEW;
    private static final Map<Integer, Ingredient> DOUGH;
    private static final Map<Integer, Ingredient> INGREDIENTS;
    private static final PizzaOrderService PIZZA_ORDER;
    private char ch;
    private int choice;

    static {
        DOUGH = new HashMap<>();
        DOUGH.put(1, Ingredient.THIN_DOUGH);
        DOUGH.put(2, Ingredient.TRADITIONAL_DOUGH);

        INGREDIENTS = new HashMap<>();
        INGREDIENTS.put(1, Ingredient.CHEESE);
        INGREDIENTS.put(2, Ingredient.MEAT);
        INGREDIENTS.put(3, Ingredient.SAUSAGES);
        INGREDIENTS.put(4, Ingredient.OLIVES);
        INGREDIENTS.put(5, Ingredient.TOMATOES);
        INGREDIENTS.put(6, Ingredient.PEPPER);
        INGREDIENTS.put(7, Ingredient.OREGANO);
        INGREDIENTS.put(8, Ingredient.SAUCE);
        INGREDIENTS.put(9, Ingredient.CRUST);

        CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();
        PIZZA_ORDER = new PizzaOrderService();
    }

    public void start() {
        CREATE_PIZZA_VIEW.greeting();
    }

    public void displayOptions() {
        CREATE_PIZZA_VIEW.displayOptions();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                chooseDough();
                break;
            case 2:
                CREATE_PIZZA_VIEW.displayInfoIngredients();
                displayOptions();
                break;
            case 3:
                PIZZA_ORDER.start();
                PIZZA_ORDER.displayOptions();
                break;
            case 4:
                break;
            default:
                CREATE_PIZZA_VIEW.choiceView();
                displayOptions();
                break;
        }
    }

    public void chooseDough() {
        CREATE_PIZZA_VIEW.menuDough();
        try {
            choice = CheckScannerInputUtil.checkInt();
            switch (DOUGH.get(choice)) {
                case THIN_DOUGH:
                    IngredientOrderUtil.orderThinDough();
                    break;
                case TRADITIONAL_DOUGH:
                    IngredientOrderUtil.orderTraditionalDough();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
                CREATE_PIZZA_VIEW.doughException();
                addDoughQuestion();
            }
        }
    }

    public void addDoughQuestion() {
        CREATE_PIZZA_VIEW.addDoughQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseDough();
        } else {
            chooseIngredients();
        }
    }

    public void chooseIngredients() {
        CREATE_PIZZA_VIEW.menuIngredients();
        try {
            choice = CheckScannerInputUtil.checkInt();
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    IngredientOrderUtil.orderCheese();
                    break;
                case MEAT:
                    IngredientOrderUtil.orderMeat();
                    break;
                case SAUSAGES:
                    IngredientOrderUtil.orderSausages();
                    break;
                case OLIVES:
                    IngredientOrderUtil.orderOlives();
                    break;
                case TOMATOES:
                    IngredientOrderUtil.orderTomatoes();
                    break;
                case PEPPER:
                    IngredientOrderUtil.orderPepper();
                    break;
                case OREGANO:
                    IngredientOrderUtil.orderOregano();
                    break;
                case SAUCE:
                    IngredientOrderUtil.orderSauce();
                    break;
                case CRUST:
                    IngredientOrderUtil.orderCrust();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                CREATE_PIZZA_VIEW.ingredientNumberException();
            }
        }
        RoundUtil.up(IngredientOrderUtil.getIngredientOrder().totalOrder());
        CREATE_PIZZA_VIEW.totalCalories(IngredientCaloriesCalculatorUtil.countTotalCalories());
    }

    public void addIngredientsQuestion() {
        CREATE_PIZZA_VIEW.addIngredientsQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseIngredients();
            addIngredientsQuestion();
        } else {
            PaymentChoiceUtil.paymentChoice();
        }
    }
}
