package com.peregud.pizza.service;

import com.peregud.pizza.util.PizzaPriceUtil;
import com.peregud.pizza.util.RoundUtil;
import com.peregud.pizza.util.SoldPizzasUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatisticsServiceTest {
    OrderStatisticsService orderStatistics = new OrderStatisticsService();

    public void putToMap() {
        SoldPizzasUtil.getSoldPizzas().put(1, 5);
        SoldPizzasUtil.getSoldPizzas().put(2, 5);
        SoldPizzasUtil.getSoldPizzas().put(3, 11);
        SoldPizzasUtil.getSoldPizzas().put(4, 1);
        SoldPizzasUtil.getSoldPizzas().put(5, 20);
    }

    @Test
    public void pizzasSold() {
        putToMap();
        assertEquals(List.of(5, 5, 11, 1, 20), orderStatistics.pizzasSold());
    }

    @Test
    public void totalPizzasSold() {
        putToMap();
        assertEquals(42, orderStatistics.totalPizzasSold());
    }

    @Test
    public void pizzasPrices() {
        putToMap();
        assertEquals(List.of(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT(),
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT(),
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT(),
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT(),
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                orderStatistics.pizzasPrices());
    }

    @Test
    public void pizzasRevenue_FourCheese() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()),
                RoundUtil.up(orderStatistics.pizzasRevenue().get(0)));
    }

    @Test
    public void pizzasRevenue_Margherita() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()),
                RoundUtil.up(orderStatistics.pizzasRevenue().get(1)));
    }

    @Test
    public void pizzasRevenue_MeatDelight() {
        putToMap();
        assertEquals(RoundUtil.up(11 * PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()),
                RoundUtil.up(orderStatistics.pizzasRevenue().get(2)));
    }

    @Test
    public void pizzasRevenue_Pepperoni() {
        putToMap();
        assertEquals(RoundUtil.up(1 * PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()),
                RoundUtil.up(orderStatistics.pizzasRevenue().get(3)));
    }

    @Test
    public void pizzasRevenue_Vegetarian() {
        putToMap();
        assertEquals(RoundUtil.up(20 * PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                RoundUtil.up(orderStatistics.pizzasRevenue().get(4)));
    }

    @Test
    public void totalRevenue() {
        putToMap();
        assertEquals(1282.32, orderStatistics.totalRevenue());
    }

    @Test
    public void averageCheck() {
        putToMap();
        assertEquals(30.53, orderStatistics.averageCheck());
    }

    @Test
    public void totalCost() {
        putToMap();
        assertEquals(822.0, orderStatistics.totalCost());
    }

    @Test
    public void totalProfit() {
        putToMap();
        assertEquals(202.21, orderStatistics.totalProfit());
    }

    @Test
    public void profitMargin() {
        putToMap();
        assertEquals(15.77, orderStatistics.profitMargin());
    }
}
