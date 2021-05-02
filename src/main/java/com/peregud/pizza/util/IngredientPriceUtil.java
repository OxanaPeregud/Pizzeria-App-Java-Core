package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IngredientPriceUtil {

    public static double priceWithoutVAT(Ingredient ingredient) {
        return ProfitUtil.profitPercentage(ingredient.getCostPerUnit());
    }

    public static double priceIncludingVAT(Ingredient ingredient) {
        return priceWithoutVAT(ingredient) + TaxUtil.VAT(priceWithoutVAT(ingredient));
    }
}
