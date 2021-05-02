package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.service.IngredientOrderCalculatorService;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IngredientOrderUtil {
    private static final IngredientOrderCalculatorService INGREDIENT_ORDER;
    private static final CreatePizzaView CREATE_PIZZA_VIEW;

    static {
        INGREDIENT_ORDER = new IngredientOrderCalculatorService(new ArrayList<>());
        CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();
    }

    public static void chooseIngredient(Ingredient ingredient) {
        getIngredientOrder().add(IngredientPriceUtil.priceIncludingVAT(ingredient));
        CookUtil.cookIngredient(ingredient);
        CheckUtil.add(CREATE_PIZZA_VIEW.orderIngredient(ingredient));
        TotalOrderCalculatorUtil.totalOrderIngredient();
    }

    public static IngredientOrderCalculatorService getIngredientOrder() {
        return INGREDIENT_ORDER;
    }
}
