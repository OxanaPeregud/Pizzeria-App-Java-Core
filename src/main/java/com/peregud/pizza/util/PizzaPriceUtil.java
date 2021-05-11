/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PizzaPriceUtil {

    public double pizzaPriceWithoutVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza));
    }

    public double pizzaPriceIncludingVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza)) + TaxUtil.VAT(pizzaPriceWithoutVAT(pizza));
    }
}
