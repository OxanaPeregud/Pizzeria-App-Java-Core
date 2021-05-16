/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.Pizza;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrderStatisticsUtilTest {

    public void putToMap() {
        SoldPizzasUtil.getSOLD_PIZZAS().put(1, 5);
        SoldPizzasUtil.getSOLD_PIZZAS().put(2, 5);
        SoldPizzasUtil.getSOLD_PIZZAS().put(3, 11);
        SoldPizzasUtil.getSOLD_PIZZAS().put(4, 1);
        SoldPizzasUtil.getSOLD_PIZZAS().put(5, 20);
    }

    @Test
    public void pizzasSold() {
        putToMap();
        assertEquals(List.of(5, 5, 11, 1, 20), OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()));
    }

    @Test
    public void totalPizzasSold() {
        putToMap();
        assertEquals(42, OrderStatisticsUtil.totalSold(SoldPizzasUtil.getSOLD_PIZZAS()));
    }

    @Test
    public void pizzasPrices() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(List.of(PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE),
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA),
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT),
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI),
                PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN)),
                OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES()));
    }

    @Test
    public void pizzasRevenue_FourCheese() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.FOUR_CHEESE)),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())).get(0)));
    }

    @Test
    public void pizzasRevenue_Margherita() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MARGHERITA)),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())).get(1)));
    }

    @Test
    public void pizzasRevenue_MeatDelight() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(11 * PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.MEAT_DELIGHT)),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())).get(2)));
    }

    @Test
    public void pizzasRevenue_Pepperoni() {
        putToMap();
        assertEquals(RoundUtil.up(1 * PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.PEPPERONI)),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())).get(3)));
    }

    @Test
    public void pizzasRevenue_Vegetarian() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(20 * PizzaPriceUtil.pizzaPriceIncludingVAT(Pizza.VEGETARIAN)),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSOLD_PIZZAS()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPIZZAS_PRICES())).get(4)));
    }

    @Test
    public void totalRevenue() {
        putToMap();
        assertEquals(1282.32, OrderStatisticsUtil.totalRevenue(SoldPizzasUtil.getSOLD_PIZZAS(),
                SoldPizzasUtil.getPIZZAS_PRICES()));
    }

    @Test
    public void averageCheck() {
        putToMap();
        assertEquals(30.53, OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSOLD_PIZZAS(),
                SoldPizzasUtil.getPIZZAS_PRICES()));
    }

    @Test
    public void totalCost() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(822.0, OrderStatisticsUtil.totalCost(SoldPizzasUtil.getSOLD_PIZZAS(),
                SoldPizzasUtil.getPIZZAS_COST()));
    }

    @Test
    public void totalProfit() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(202.21, OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSOLD_PIZZAS(),
                SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
    }

    @Test
    public void profitMargin() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(15.77, OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSOLD_PIZZAS(),
                SoldPizzasUtil.getPIZZAS_PRICES(), SoldPizzasUtil.getPIZZAS_COST()));
    }

    @Test
    public void testPrivateConstructor() {
        Class<OrderStatisticsUtil> clazz = null;
        try {
            clazz = OrderStatisticsUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
