/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PizzaPriceUtil {

    public static double pizzaPriceWithoutVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza));
    }

    public static double pizzaPriceIncludingVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza)) + TaxUtil.VAT(pizzaPriceWithoutVAT(pizza));
    }
}
