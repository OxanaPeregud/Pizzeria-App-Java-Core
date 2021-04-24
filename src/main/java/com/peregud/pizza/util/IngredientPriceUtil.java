package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;

public final class IngredientPriceUtil {

    private IngredientPriceUtil() {
    }

    public static double priceWithoutVAT(Ingredient ingredient) {
        return ProfitUtil.profitPercentage(ingredient.getCostPerUnit());
    }

    public static double priceIncludingVAT(Ingredient ingredient) {
        return priceWithoutVAT(ingredient) + TaxUtil.VAT(priceWithoutVAT(ingredient));
    }
}
