/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientPriceUtilTest {

    @Test
    public void priceThinDoughWithoutVAT() {
        assertEquals(2.47, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.THIN_DOUGH)));
    }

    @Test
    public void priceThinDoughIncludingVAT() {
        assertEquals(2.96, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.THIN_DOUGH)));
    }

    @Test
    public void priceTraditionalDoughWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.TRADITIONAL_DOUGH)));
    }

    @Test
    public void priceTraditionalDoughIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.TRADITIONAL_DOUGH)));
    }

    @Test
    public void priceCheeseWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.CHEESE)));
    }

    @Test
    public void priceCheeseIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.CHEESE)));
    }

    @Test
    public void priceMeatWithoutVAT() {
        assertEquals(6.76, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.MEAT)));
    }

    @Test
    public void priceMeatIncludingVAT() {
        assertEquals(8.11, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.MEAT)));
    }

    @Test
    public void priceSausagesWithoutVAT() {
        assertEquals(7.8, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.SAUSAGES)));
    }

    @Test
    public void priceSausagesIncludingVAT() {
        assertEquals(9.36, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.SAUSAGES)));
    }

    @Test
    public void priceOlivesWithoutVAT() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.OLIVES)));
    }

    @Test
    public void priceOlivesIncludingVAT() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.OLIVES)));
    }

    @Test
    public void priceTomatoesWithoutVAT() {
        assertEquals(1.95, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.TOMATOES)));
    }

    @Test
    public void priceTomatoesIncludingVAT() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.TOMATOES)));
    }

    @Test
    public void pricePepperWithoutVAT() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.PEPPER)));
    }

    @Test
    public void pricePepperIncludingVAT() {
        assertEquals(2.81, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.PEPPER)));
    }

    @Test
    public void priceOreganoWithoutVAT() {
        assertEquals(1.43, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.OREGANO)));
    }

    @Test
    public void priceOreganoIncludingVAT() {
        assertEquals(1.72, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.OREGANO)));
    }

    @Test
    public void priceSauceWithoutVAT() {
        assertEquals(1.3, RoundUtil.up(IngredientPriceUtil.priceWithoutVAT(Ingredient.SAUCE)));
    }

    @Test
    public void priceSauceIncludingVAT() {
        assertEquals(1.56, RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(Ingredient.SAUCE)));
    }
}
