package com.peregud.pizza.util;

public final class PizzaPriceUtil {

    private PizzaPriceUtil() {
    }

    public static double pricePizzaFourCheeseWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.costFourCheese());
    }

    public static double pricePizzaFourCheeseIncludingVAT() {
        return pricePizzaFourCheeseWithoutVAT() + TaxUtil.VAT(pricePizzaFourCheeseWithoutVAT());
    }

    public static double pricePizzaMargheritaWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.costMargherita());
    }

    public static double pricePizzaMargheritaIncludingVAT() {
        return pricePizzaMargheritaWithoutVAT() + TaxUtil.VAT(pricePizzaMargheritaWithoutVAT());
    }

    public static double pricePizzaMeatDelightWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.costMeatDelight());
    }

    public static double pricePizzaMeatDelightIncludingVAT() {
        return pricePizzaMeatDelightWithoutVAT() + TaxUtil.VAT(pricePizzaMeatDelightWithoutVAT());
    }

    public static double pricePizzaPepperoniWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.costPepperoni());
    }

    public static double pricePizzaPepperoniIncludingVAT() {
        return pricePizzaPepperoniWithoutVAT() + TaxUtil.VAT(pricePizzaPepperoniWithoutVAT());
    }

    public static double pricePizzaVegetarianWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.costVegetarian());
    }

    public static double pricePizzaVegetarianIncludingVAT() {
        return pricePizzaVegetarianWithoutVAT() + TaxUtil.VAT(pricePizzaVegetarianWithoutVAT());
    }
}
