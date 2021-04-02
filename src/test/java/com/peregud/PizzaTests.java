package com.peregud;

import com.peregud.pizza.controller.OrderStatisticsController;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.repository.StorageRepository;
import com.peregud.pizza.service.CashPaymentService;
import com.peregud.pizza.service.CookService;
import com.peregud.pizza.service.OrderStatisticsService;
import com.peregud.pizza.util.*;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final CashPaymentService CASH_PAYMENT;
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final CookService COOK;
    private static final StorageRepository STORAGE;

    static {
        CASH_PAYMENT = new CashPaymentService();
        ORDER_STATISTICS = new OrderStatisticsService();
        COOK = new CookService();
        STORAGE = new StorageRepository();
    }

    @Test
    public void countChange_CashPaymentService() {
        CashPaymentService.fullAmount = 250;
        assertEquals(150, CASH_PAYMENT.countChange(100));
    }

    @Test
    public void pizzaFourCheese_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.pizzaFourCheese();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaFourCheese_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.pizzaFourCheese();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaFourCheese_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.pizzaFourCheese();
        assertEquals(oldQuantity - 4, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaFourCheese_Oregano_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        COOK.pizzaFourCheese();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMargherita_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.pizzaMargherita();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMargherita_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.pizzaMargherita();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMargherita_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.pizzaMargherita();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMargherita_Tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        COOK.pizzaMargherita();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaMargherita_Oregano_CookService() {
        int oldQuantityOregano = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        COOK.pizzaMargherita();
        assertEquals(oldQuantityOregano - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMeatDelight_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.pizzaMeatDelight();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMeatDelight_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.pizzaMeatDelight();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMeatDelight_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.pizzaMeatDelight();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMeatDelight_Meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        COOK.pizzaMeatDelight();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaMeatDelight_Sausages_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUSAGES);
        COOK.pizzaMeatDelight();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void pizzaPepperoni_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.pizzaPepperoni();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaPepperoni_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.pizzaPepperoni();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaPepperoni_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.pizzaPepperoni();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaPepperoni_Meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        COOK.pizzaPepperoni();
        assertEquals(oldQuantity - 3, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaVegetarian_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaVegetarian_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaVegetarian_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaVegetarian_Tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaVegetarian_Pepper_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.PEPPER);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void pizzaVegetarian_Olives_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OLIVES);
        COOK.pizzaVegetarian();
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void thinDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH);
        COOK.thinDough();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void traditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        COOK.traditionalDough();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        COOK.cheese();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        COOK.meat();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void sausages_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUSAGES);
        COOK.sausages();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void olives_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OLIVES);
        COOK.olives();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        COOK.tomatoes();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pepper_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.PEPPER);
        COOK.pepper();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void oregano_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        COOK.oregano();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        COOK.sauce();
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
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

    public void putToMap() {
        OrderStatisticsController.SOLD_PIZZAS.put(1, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(2, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(3, 11);
        OrderStatisticsController.SOLD_PIZZAS.put(4, 1);
        OrderStatisticsController.SOLD_PIZZAS.put(5, 20);
    }

    @Test
    public void pizzasSold_OrderStatisticsService() {
        putToMap();
        assertEquals(List.of(5, 5, 11, 1, 20), ORDER_STATISTICS.pizzasSold());
    }

    @Test
    public void totalPizzasSold_OrderStatisticsService() {
        putToMap();
        assertEquals(42, ORDER_STATISTICS.totalPizzasSold());
    }

    @Test
    public void pizzasPrices_OrderStatisticsService() {
        putToMap();
        assertEquals(List.of(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT(),
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT(),
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT(),
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT(),
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                ORDER_STATISTICS.pizzasPrices());
    }

    @Test
    public void pizzasRevenue_FourCheese_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(0)));
    }

    @Test
    public void pizzasRevenue_Margherita_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(1)));
    }

    @Test
    public void pizzasRevenue_MeatDelight_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(11 * PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(2)));
    }

    @Test
    public void pizzasRevenue_Pepperoni_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(1 * PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(3)));
    }

    @Test
    public void pizzasRevenue_Vegetarian_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(20 * PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(4)));
    }

    @Test
    public void totalRevenue_OrderStatisticsService() {
        putToMap();
        assertEquals(1282.32, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    public void averageCheck_OrderStatisticsService() {
        putToMap();
        assertEquals(30.53, ORDER_STATISTICS.averageCheck());
    }

    @Test
    public void totalCost_OrderStatisticsService() {
        putToMap();
        assertEquals(822.0, ORDER_STATISTICS.totalCost());
    }

    @Test
    public void totalProfit_OrderStatisticsService() {
        putToMap();
        assertEquals(202.21, ORDER_STATISTICS.totalProfit());
    }

    @Test
    public void profitMargin_OrderStatisticsService() {
        putToMap();
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
