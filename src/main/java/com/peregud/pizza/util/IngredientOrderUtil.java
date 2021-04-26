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

    public static void chooseIngredient(Ingredient ingredient) {
        getIngredientOrder().add(IngredientPriceUtil.priceIncludingVAT(ingredient));
        CookUtil.cookIngredient(ingredient);
        Check.add(CREATE_PIZZA_VIEW.orderIngredient(ingredient));
        TotalOrderCalculatorUtil.totalOrderIngredient();
    }

    public static IngredientOrderCalculatorService getIngredientOrder() {
        return INGREDIENT_ORDER;
    }
}
