package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaPriceUtilTest {

    @Test
    public void pricePizzaFourCheeseWithoutVAT() {
        assertEquals(18.98, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    public void pricePizzaFourCheeseIncludingVAT() {
        assertEquals(22.78, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    public void pricePizzaMargheritaWithoutVAT() {
        assertEquals(16.38, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    public void pricePizzaMargheritaIncludingVAT() {
        assertEquals(19.66, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    public void pricePizzaMeatDelightWithoutVAT() {
        assertEquals(36.92, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    public void pricePizzaMeatDelightIncludingVAT() {
        assertEquals(44.3, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    public void pricePizzaPepperoniWithoutVAT() {
        assertEquals(28.08, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    public void pricePizzaPepperoniIncludingVAT() {
        assertEquals(33.7, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    public void pricePizzaVegetarianWithoutVAT() {
        assertEquals(22.88, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    public void pricePizzaVegetarianIncludingVAT() {
        assertEquals(27.46, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()));
    }
}
