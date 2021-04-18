package com.peregud.pizza.util;

import com.peregud.pizza.service.IngredientOrderCalculatorService;

import java.util.ArrayList;

public final class IngredientOrderUtil {
    private static final IngredientOrderCalculatorService INGREDIENT_ORDER;

    static {
        INGREDIENT_ORDER = new IngredientOrderCalculatorService(new ArrayList<>());
    }

    private IngredientOrderUtil() {
    }

    public static IngredientOrderCalculatorService getIngredientOrder() {
        return INGREDIENT_ORDER;
    }
}
