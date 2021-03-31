package com.peregud;

import com.peregud.pizza.controller.OrderStatisticsController;
import com.peregud.pizza.service.CashPaymentService;
import com.peregud.pizza.service.OrderStatisticsService;
import com.peregud.pizza.util.*;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final CashPaymentService CASH_PAYMENT;
    private static final OrderStatisticsService ORDER_STATISTICS;

    static {
        CASH_PAYMENT = new CashPaymentService();
        ORDER_STATISTICS = new OrderStatisticsService();
    }

    @Test
    public void countChange_CashPaymentService() {
        CashPaymentService.fullAmount = 250;
        assertEquals(150, CASH_PAYMENT.countChange(100));
    }

    @Test
    public void discountForTwoItems_DiscountService() {
        assertEquals(90, DiscountUtil.discountForTwoItems(100));
    }

    @Test
    public void discountForThreeAndMoreItems_DiscountService() {
        assertEquals(80, DiscountUtil.discountForThreeAndMoreItems(100));
    }

    @Test
    public void discountForOrderOnSpecificDay_DiscountService() {
        assertEquals(85, DiscountUtil.discountForOrderOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor2PizzasOnSpecificDay_DiscountService() {
        assertEquals(75, DiscountUtil.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor3AndMorePizzasOnSpecificDay_DiscountService() {
        assertEquals(65, DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }

    @Test
    public void priceThinDoughWithoutVAT_IngredientPriceService() {
        assertEquals(2.47, RoundUtil.up(IngredientPriceUtil.priceThinDoughWithoutVAT()));
    }

    @Test
    public void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()));
    }

    @Test
    public void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    public void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    public void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceCheeseWithoutVAT()));
    }

    @Test
    public void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()));
    }

    @Test
    public void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUtil.up(IngredientPriceUtil.priceMeatWithoutVAT()));
    }

    @Test
    public void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()));
    }

    @Test
    public void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUtil.up(IngredientPriceUtil.priceSausagesWithoutVAT()));
    }

    @Test
    public void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()));
    }

    @Test
    public void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceOlivesWithoutVAT()));
    }

    @Test
    public void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()));
    }

    @Test
    public void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUtil.up(IngredientPriceUtil.priceTomatoesWithoutVAT()));
    }

    @Test
    public void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()));
    }

    @Test
    public void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.pricePepperWithoutVAT()));
    }

    @Test
    public void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()));
    }

    @Test
    public void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUtil.up(IngredientPriceUtil.priceOreganoWithoutVAT()));
    }

    @Test
    public void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()));
    }

    @Test
    public void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUtil.up(IngredientPriceUtil.priceSauceWithoutVAT()));
    }

    @Test
    public void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()));
    }

    @Test
    public void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUtil.up(IngredientPriceUtil.priceCrustWithoutVAT()));
    }

    @Test
    public void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()));
    }

    public void putToMaps() {
        OrderStatisticsController.SOLD_PIZZAS.put(1, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(2, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(3, 11);
        OrderStatisticsController.SOLD_PIZZAS.put(4, 1);
        OrderStatisticsController.SOLD_PIZZAS.put(5, 20);
    }

    @Test
    public void pizzasSold_OrderStatisticsService() {
        putToMaps();
        assertEquals(List.of(5, 5, 11, 1, 20), ORDER_STATISTICS.pizzasSold());
    }

    @Test
    public void totalPizzasSold_OrderStatisticsService() {
        putToMaps();
        assertEquals(42, ORDER_STATISTICS.totalPizzasSold());
    }

    @Test
    public void pizzasPrices_OrderStatisticsService() {
        putToMaps();
        assertEquals(List.of(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT(),
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT(),
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT(),
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT(),
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                ORDER_STATISTICS.pizzasPrices());
    }

    @Test
    public void totalRevenue_OrderStatisticsService() {
        putToMaps();
        assertEquals(1282.32, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    public void averageCheck_OrderStatisticsService() {
        putToMaps();
        assertEquals(30.53, ORDER_STATISTICS.averageCheck());
    }

    @Test
    public void totalCost_OrderStatisticsService() {
        putToMaps();
        assertEquals(822.0, ORDER_STATISTICS.totalCost());
    }

    @Test
    public void totalProfit_OrderStatisticsService() {
        putToMaps();
        assertEquals(202.21, ORDER_STATISTICS.totalProfit());
    }

    @Test
    public void profitMargin_OrderStatisticsService() {
        putToMaps();
        assertEquals(15.77, ORDER_STATISTICS.profitMargin());
    }

    @Test
    public void caloriesPizzaFourCheese_PizzaCaloriesService() {
        assertEquals(1750, PizzaCaloriesUtil.caloriesPizzaFourCheese());
    }

    @Test
    public void caloriesPizzaMargherita_PizzaCaloriesService() {
        assertEquals(1420, PizzaCaloriesUtil.caloriesPizzaMargherita());
    }

    @Test
    public void caloriesPizzaMeatDelight_PizzaCaloriesService() {
        assertEquals(1740, PizzaCaloriesUtil.caloriesPizzaMeatDelight());
    }

    @Test
    public void caloriesPizzaPepperoni_PizzaCaloriesService() {
        assertEquals(1320, PizzaCaloriesUtil.caloriesPizzaPepperoni());
    }

    @Test
    public void caloriesPizzaVegetarian_PizzaCaloriesService() {
        assertEquals(990, PizzaCaloriesUtil.caloriesPizzaVegetarian());
    }

    @Test
    public void getCostFourCheese_PizzaCostService() {
        assertEquals(14.6, PizzaCostUtil.getCostFourCheese());
    }

    @Test
    public void getCostMargherita_PizzaCostService() {
        assertEquals(12.6, PizzaCostUtil.getCostMargherita());
    }

    @Test
    public void getCostMeatDelight_PizzaCostService() {
        assertEquals(28.4, PizzaCostUtil.getCostMeatDelight());
    }

    @Test
    public void getCostPepperoni_PizzaCostService() {
        assertEquals(21.6, PizzaCostUtil.getCostPepperoni());
    }

    @Test
    public void getCostVegetarian_PizzaCostService() {
        assertEquals(17.6, PizzaCostUtil.getCostVegetarian());
    }

    @Test
    public void pricePizzaFourCheeseWithoutVAT_PizzaPriceService() {
        assertEquals(18.98, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    public void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    public void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    public void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    public void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    public void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    public void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    public void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    public void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    public void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    public void profitPercentage_ProfitService() {
        assertEquals(130, ProfitUtil.profitPercentage(100));
    }

    @Test
    public void VAT_TaxService() {
        assertEquals(20, TaxUtil.VAT(100));
    }

    @Test
    public void VATonRevenue_TaxService() {
        assertEquals(20, TaxUtil.VATonRevenue(120));
    }

    @Test
    public void CorporateIncomeTax_TaxService() {
        assertEquals(82, TaxUtil.CorporateIncomeTax(100));
    }
}
