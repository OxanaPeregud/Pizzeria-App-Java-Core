/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaService {
    private final CreatePizzaView createPizzaView = new CreatePizzaViewConsole();
    private final PizzaOrderService pizzaOrder = new PizzaOrderService();
    private static final Map<Integer, Ingredient> DOUGH;
    private static final Map<Integer, Ingredient> INGREDIENTS;
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
    }

    public void start() {
        createPizzaView.greeting();
    }

    public void displayOptions() {
        createPizzaView.displayOptions();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                chooseDough();
                break;
            case 2:
                createPizzaView.displayInfoAboutIngredient(Ingredient.CHEESE);
                createPizzaView.displayInfoAboutIngredient(Ingredient.MEAT);
                createPizzaView.displayInfoAboutIngredient(Ingredient.OLIVES);
                createPizzaView.displayInfoAboutIngredient(Ingredient.OREGANO);
                createPizzaView.displayInfoAboutIngredient(Ingredient.PEPPER);
                createPizzaView.displayInfoAboutIngredient(Ingredient.SAUCE);
                createPizzaView.displayInfoAboutIngredient(Ingredient.SAUSAGES);
                createPizzaView.displayInfoAboutIngredient(Ingredient.THIN_DOUGH);
                createPizzaView.displayInfoAboutIngredient(Ingredient.TOMATOES);
                createPizzaView.displayInfoAboutIngredient(Ingredient.TRADITIONAL_DOUGH);
                displayOptions();
                break;
            case 3:
                pizzaOrder.choosePizza();
                break;
            case 4:
                break;
            default:
                createPizzaView.choiceView();
                displayOptions();
                break;
        }
    }

    public void chooseDough() {
        createPizzaView.menuDough();
        choice = CheckScannerInputUtil.checkInt();
        if (DOUGH.get(choice) != null) {
            switch (DOUGH.get(choice)) {
                case THIN_DOUGH:
                    chooseIngredient(Ingredient.THIN_DOUGH);
                    break;
                case TRADITIONAL_DOUGH:
                    chooseIngredient(Ingredient.TRADITIONAL_DOUGH);
                    break;
            }
        } else {
            createPizzaView.doughException();
            chooseDough();
        }
    }

    public void chooseIngredients() {
        createPizzaView.menuIngredients();
        choice = CheckScannerInputUtil.checkInt();
        if (INGREDIENTS.get(choice) != null) {
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
        } else {
            createPizzaView.ingredientNumberException();
            chooseIngredients();
        }
        RoundUtil.up(IngredientOrderUtil.getIngredientOrder().totalOrder());
        createPizzaView.totalCalories(IngredientCaloriesCalculatorUtil.countTotalCalories());
    }

    public void chooseIngredient(Ingredient ingredient) {
        IngredientOrderUtil.chooseIngredient(ingredient);
        IngredientCaloriesCalculatorUtil.add(ingredient.getCalories());
    }

    public void addIngredientsQuestion() {
        createPizzaView.addIngredientsQuestion();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseIngredients();
            addIngredientsQuestion();
        } else {
            PaymentChoiceUtil.paymentChoice();
        }
    }
}
