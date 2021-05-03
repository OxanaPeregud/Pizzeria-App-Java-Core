/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientPriceUtil {

    public static double priceWithoutVAT(Ingredient ingredient) {
        return ProfitUtil.profitPercentage(ingredient.getCostPerUnit());
    }

    public static double priceIncludingVAT(Ingredient ingredient) {
        return priceWithoutVAT(ingredient) + TaxUtil.VAT(priceWithoutVAT(ingredient));
    }
}
