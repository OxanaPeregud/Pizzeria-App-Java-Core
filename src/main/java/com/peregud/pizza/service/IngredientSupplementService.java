package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.CheckUtil;
import com.peregud.pizza.util.ChoiceUtil;
import com.peregud.pizza.util.IngredientOrderUtil;
import com.peregud.pizza.util.IngredientPriceUtil;
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
    private static final CookService COOK;
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
        COOK = new CookService();
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
    }

    public void chooseIngredients() throws IOException {
        CREATE_PIZZA_VIEW.menuIngredients();
        try {
            int choice = CheckUtil.checkInt();
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceCheeseIncludingVAT());
                    COOK.cheese();
                    Check.add(CREATE_PIZZA_VIEW.orderCheese());
                    break;
                case MEAT:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceMeatIncludingVAT());
                    COOK.meat();
                    Check.add(CREATE_PIZZA_VIEW.orderMeat());
                    break;
                case SAUSAGES:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceSausagesIncludingVAT());
                    COOK.sausages();
                    Check.add(CREATE_PIZZA_VIEW.orderSausages());
                    break;
                case OLIVES:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceOlivesIncludingVAT());
                    COOK.olives();
                    Check.add(CREATE_PIZZA_VIEW.orderOlives());
                    break;
                case TOMATOES:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceTomatoesIncludingVAT());
                    COOK.tomatoes();
                    Check.add(CREATE_PIZZA_VIEW.orderTomatoes());
                    break;
                case PEPPER:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.pricePepperIncludingVAT());
                    COOK.pepper();
                    Check.add(CREATE_PIZZA_VIEW.orderPepper());
                    break;
                case OREGANO:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceOreganoIncludingVAT());
                    COOK.oregano();
                    Check.add(CREATE_PIZZA_VIEW.orderOregano());
                    break;
                case SAUCE:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceSauceIncludingVAT());
                    COOK.sauce();
                    Check.add(CREATE_PIZZA_VIEW.orderSauce());
                    break;
                case CRUST:
                    IngredientOrderUtil.getIngredientOrder().add(IngredientPriceUtil.priceCrustIncludingVAT());
                    Check.add(CREATE_PIZZA_VIEW.orderCrust());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                CREATE_PIZZA_VIEW.ingredientNumberException();
            }
        }
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }
}
