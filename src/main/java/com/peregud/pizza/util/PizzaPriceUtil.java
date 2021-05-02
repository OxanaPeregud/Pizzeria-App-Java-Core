package com.peregud.pizza.util;

import com.peregud.pizza.model.Pizza;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PizzaPriceUtil {

    public static double pizzaPriceWithoutVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza));
    }

    public static double pizzaPriceIncludingVAT(Pizza pizza) {
        return ProfitUtil.profitPercentage(PizzaCostUtil.pizzaCost(pizza)) + TaxUtil.VAT(pizzaPriceWithoutVAT(pizza));
    }
}
