package com.peregud.pizza.util;

import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.service.IngredientOrderCalculatorService;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;

import java.util.ArrayList;

public final class IngredientOrderUtil {
    private static final IngredientOrderCalculatorService INGREDIENT_ORDER;
    private static final CreatePizzaView CREATE_PIZZA_VIEW;

    static {
        INGREDIENT_ORDER = new IngredientOrderCalculatorService(new ArrayList<>());
        CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();
    }

    private IngredientOrderUtil() {
    }

    public static void orderThinDough() {
        getIngredientOrder().add(IngredientPriceUtil.priceThinDoughIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.THIN_DOUGH.getCalories());
        CookUtil.cookIngredient(Ingredient.THIN_DOUGH);
        Check.add(CREATE_PIZZA_VIEW.orderThinDough());
    }

    public static void orderTraditionalDough() {
        getIngredientOrder().add(IngredientPriceUtil.priceTraditionalDoughIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.TRADITIONAL_DOUGH.getCalories());
        CookUtil.cookIngredient(Ingredient.TRADITIONAL_DOUGH);
        Check.add(CREATE_PIZZA_VIEW.orderTraditionalDough());
    }

    public static void orderCheese() {
        getIngredientOrder().add(IngredientPriceUtil.priceCheeseIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.CHEESE.getCalories());
        CookUtil.cookIngredient(Ingredient.CHEESE);
        Check.add(CREATE_PIZZA_VIEW.orderCheese());
    }

    public static void orderMeat() {
        getIngredientOrder().add(IngredientPriceUtil.priceMeatIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.MEAT.getCalories());
        CookUtil.cookIngredient(Ingredient.MEAT);
        Check.add(CREATE_PIZZA_VIEW.orderMeat());
    }

    public static void orderSausages() {
        getIngredientOrder().add(IngredientPriceUtil.priceSausagesIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.SAUSAGES.getCalories());
        CookUtil.cookIngredient(Ingredient.SAUSAGES);
        Check.add(CREATE_PIZZA_VIEW.orderSausages());
    }

    public static void orderOlives() {
        getIngredientOrder().add(IngredientPriceUtil.priceOlivesIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.OLIVES.getCalories());
        CookUtil.cookIngredient(Ingredient.OLIVES);
        Check.add(CREATE_PIZZA_VIEW.orderOlives());
    }

    public static void orderTomatoes() {
        getIngredientOrder().add(IngredientPriceUtil.priceTomatoesIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.TOMATOES.getCalories());
        CookUtil.cookIngredient(Ingredient.TOMATOES);
        Check.add(CREATE_PIZZA_VIEW.orderTomatoes());
    }

    public static void orderPepper() {
        getIngredientOrder().add(IngredientPriceUtil.pricePepperIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.PEPPER.getCalories());
        CookUtil.cookIngredient(Ingredient.PEPPER);
        Check.add(CREATE_PIZZA_VIEW.orderPepper());
    }

    public static void orderOregano() {
        getIngredientOrder().add(IngredientPriceUtil.priceOreganoIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.OREGANO.getCalories());
        CookUtil.cookIngredient(Ingredient.OREGANO);
        Check.add(CREATE_PIZZA_VIEW.orderOregano());
    }

    public static void orderSauce() {
        getIngredientOrder().add(IngredientPriceUtil.priceSauceIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.SAUCE.getCalories());
        CookUtil.cookIngredient(Ingredient.SAUCE);
        Check.add(CREATE_PIZZA_VIEW.orderSauce());
    }

    public static void orderCrust() {
        getIngredientOrder().add(IngredientPriceUtil.priceCrustIncludingVAT());
        IngredientCaloriesCalculatorUtil.add(Ingredient.CRUST.getCalories());
        Check.add(CREATE_PIZZA_VIEW.orderCrust());
    }

    public static IngredientOrderCalculatorService getIngredientOrder() {
        return INGREDIENT_ORDER;
    }
}
