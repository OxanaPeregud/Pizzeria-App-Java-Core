package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientPriceUtilTest {

    @Test
    public void priceThinDoughWithoutVAT() {
        assertEquals(2.47, RoundUtil.up(IngredientPriceUtil.priceThinDoughWithoutVAT()));
    }

    @Test
    public void priceThinDoughIncludingVAT() {
        assertEquals(2.96, RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()));
    }

    @Test
    public void priceTraditionalDoughWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    public void priceTraditionalDoughIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    public void priceCheeseWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceCheeseWithoutVAT()));
    }

    @Test
    public void priceCheeseIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()));
    }

    @Test
    public void priceMeatWithoutVAT() {
        assertEquals(6.76, RoundUtil.up(IngredientPriceUtil.priceMeatWithoutVAT()));
    }

    @Test
    public void priceMeatIncludingVAT() {
        assertEquals(8.11, RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()));
    }

    @Test
    public void priceSausagesWithoutVAT() {
        assertEquals(7.8, RoundUtil.up(IngredientPriceUtil.priceSausagesWithoutVAT()));
    }

    @Test
    public void priceSausagesIncludingVAT() {
        assertEquals(9.36, RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()));
    }

    @Test
    public void priceOlivesWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceOlivesWithoutVAT()));
    }

    @Test
    public void priceOlivesIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()));
    }

    @Test
    public void priceTomatoesWithoutVAT() {
        assertEquals(1.95, RoundUtil.up(IngredientPriceUtil.priceTomatoesWithoutVAT()));
    }

    @Test
    public void priceTomatoesIncludingVAT() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()));
    }

    @Test
    public void pricePepperWithoutVAT() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.pricePepperWithoutVAT()));
    }

    @Test
    public void pricePepperIncludingVAT() {
        assertEquals(2.81, RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()));
    }

    @Test
    public void priceOreganoWithoutVAT() {
        assertEquals(1.43, RoundUtil.up(IngredientPriceUtil.priceOreganoWithoutVAT()));
    }

    @Test
    public void priceOreganoIncludingVAT() {
        assertEquals(1.72, RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()));
    }

    @Test
    public void priceSauceWithoutVAT() {
        assertEquals(1.3, RoundUtil.up(IngredientPriceUtil.priceSauceWithoutVAT()));
    }

    @Test
    public void priceSauceIncludingVAT() {
        assertEquals(1.56, RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()));
    }

    @Test
    public void priceCrustWithoutVAT() {
        assertEquals(2.6, RoundUtil.up(IngredientPriceUtil.priceCrustWithoutVAT()));
    }

    @Test
    public void priceCrustIncludingVAT() {
        assertEquals(3.12, RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()));
    }
}
