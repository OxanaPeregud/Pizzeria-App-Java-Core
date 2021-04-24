package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IngredientSupplementService {
    private static final CreatePizzaView CREATE_PIZZA_VIEW;
    private static final Map<Integer, Ingredient> INGREDIENTS;
    private static final PizzaOrderView PIZZA_ORDER_VIEW;

    static {
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
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
    }

    public void chooseIngredients() throws IOException {
        CREATE_PIZZA_VIEW.menuIngredients();
        try {
            int choice = CheckScannerInputUtil.checkInt();
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    IngredientOrderUtil.chooseIngredient(Ingredient.CHEESE);
                    break;
                case MEAT:
                    IngredientOrderUtil.chooseIngredient(Ingredient.MEAT);
                    break;
                case SAUSAGES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.SAUSAGES);
                    break;
                case OLIVES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.OLIVES);
                    break;
                case TOMATOES:
                    IngredientOrderUtil.chooseIngredient(Ingredient.TOMATOES);
                    break;
                case PEPPER:
                    IngredientOrderUtil.chooseIngredient(Ingredient.PEPPER);
                    break;
                case OREGANO:
                    IngredientOrderUtil.chooseIngredient(Ingredient.OREGANO);
                    break;
                case SAUCE:
                    IngredientOrderUtil.chooseIngredient(Ingredient.SAUCE);
                    break;
                case CRUST:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceIncludingVAT(Ingredient.CRUST));
                    Check.add(CREATE_PIZZA_VIEW.orderIngredient(Ingredient.CRUST));
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
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }
}
