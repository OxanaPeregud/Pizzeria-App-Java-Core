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
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.CHEESE);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.MEAT);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.OLIVES);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.OREGANO);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.PEPPER);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.SAUCE);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.SAUSAGES);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.THIN_DOUGH);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.TOMATOES);
                CREATE_PIZZA_VIEW.displayInfoAboutIngredient(Ingredient.TRADITIONAL_DOUGH);
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
                    chooseIngredient(Ingredient.THIN_DOUGH);
                    break;
                case TRADITIONAL_DOUGH:
                    chooseIngredient(Ingredient.TRADITIONAL_DOUGH);
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
                ex.printStackTrace();
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
                    chooseIngredient(Ingredient.CHEESE);
                    break;
                case MEAT:
                    chooseIngredient(Ingredient.MEAT);
                    break;
                case SAUSAGES:
                    chooseIngredient(Ingredient.SAUSAGES);
                    break;
                case OLIVES:
                    chooseIngredient(Ingredient.OLIVES);
                    break;
                case TOMATOES:
                    chooseIngredient(Ingredient.TOMATOES);
                    break;
                case PEPPER:
                    chooseIngredient(Ingredient.PEPPER);
                    break;
                case OREGANO:
                    chooseIngredient(Ingredient.OREGANO);
                    break;
                case SAUCE:
                    chooseIngredient(Ingredient.SAUCE);
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                ex.printStackTrace();
                CREATE_PIZZA_VIEW.ingredientNumberException();
            }
        }
        RoundUtil.up(IngredientOrderUtil.getIngredientOrder().totalOrder());
        CREATE_PIZZA_VIEW.totalCalories(IngredientCaloriesCalculatorUtil.countTotalCalories());
    }

    public void chooseIngredient(Ingredient ingredient) {
        IngredientOrderUtil.chooseIngredient(ingredient);
        IngredientCaloriesCalculatorUtil.add(ingredient.getCalories());
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
