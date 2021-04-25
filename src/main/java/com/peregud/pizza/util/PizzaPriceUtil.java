package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;

public final class PizzaPriceUtil {

    private PizzaPriceUtil() {
    }

    public static double pizzaPriceWithoutVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza));
    }

    public static double pizzaPriceIncludingVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza)) + TaxUtil.VAT(pizzaPriceWithoutVAT(pizza));
    }
}
