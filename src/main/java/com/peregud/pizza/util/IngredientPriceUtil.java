/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Ingredient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IngredientPriceUtil {

    public double priceWithoutVAT(Ingredient ingredient) {
        return ProfitUtil.profitPercentage(ingredient.getCostPerUnit());
    }

    public double priceIncludingVAT(Ingredient ingredient) {
        return priceWithoutVAT(ingredient) + TaxUtil.VAT(priceWithoutVAT(ingredient));
    }
}
