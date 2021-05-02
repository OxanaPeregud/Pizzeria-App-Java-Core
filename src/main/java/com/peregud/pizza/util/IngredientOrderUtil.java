package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.service.IngredientOrderCalculatorService;
import com.peregud.pizza.view.CreatePizzaView;
import com.peregud.pizza.view.CreatePizzaViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientOrderUtil {
    private static final IngredientOrderCalculatorService INGREDIENT_ORDER =
            new IngredientOrderCalculatorService(new ArrayList<>());
    private static final CreatePizzaView CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();

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
