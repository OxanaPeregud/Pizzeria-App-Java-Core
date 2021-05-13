/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Ingredient;
import com.peregud.pizza.service.IngredientOrderCalculatorService;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class IngredientOrderUtil {
    private final IngredientOrderCalculatorService INGREDIENT_ORDER =
            new IngredientOrderCalculatorService(new ArrayList<>());
    private final CreatePizzaView CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();

    public void chooseIngredient(Ingredient ingredient) {
        getIngredientOrder().add(IngredientPriceUtil.priceIncludingVAT(ingredient));
        CookUtil.cookIngredient(ingredient);
        CheckUtil.add(CREATE_PIZZA_VIEW.orderIngredient(ingredient));
        TotalOrderCalculatorUtil.totalOrder(OrderPizzaUtil.getPIZZA_ORDER().totalOrder(),
                IngredientOrderUtil.getIngredientOrder().totalOrder());
    }

    public IngredientOrderCalculatorService getIngredientOrder() {
        return INGREDIENT_ORDER;
    }
}
