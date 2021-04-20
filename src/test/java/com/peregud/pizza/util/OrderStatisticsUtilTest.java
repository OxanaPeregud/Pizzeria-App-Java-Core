package com.peregud.pizza.util;

import com.peregud.pizza.util.OrderStatisticsUtil;
import com.peregud.pizza.util.PizzaPriceUtil;
import com.peregud.pizza.util.RoundUtil;
import com.peregud.pizza.util.SoldPizzasUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatisticsUtilTest {

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
        assertEquals(List.of(5, 5, 11, 1, 20), OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()));
    }

    @Test
    public void totalPizzasSold() {
        putToMap();
        assertEquals(42, OrderStatisticsUtil.totalSold(SoldPizzasUtil.getSoldPizzas()));
    }

    @Test
    public void pizzasPrices() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(List.of(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT(),
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT(),
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT(),
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT(),
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices()));
    }

    @Test
    public void pizzasRevenue_FourCheese() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices())).get(0)));
    }

    @Test
    public void pizzasRevenue_Margherita() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices())).get(1)));
    }

    @Test
    public void pizzasRevenue_MeatDelight() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(11 * PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices())).get(2)));
    }

    @Test
    public void pizzasRevenue_Pepperoni() {
        putToMap();
        assertEquals(RoundUtil.up(1 * PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices())).get(3)));
    }

    @Test
    public void pizzasRevenue_Vegetarian() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        assertEquals(RoundUtil.up(20 * PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                RoundUtil.up(OrderStatisticsUtil.revenue(OrderStatisticsUtil.soldItems(SoldPizzasUtil.getSoldPizzas()),
                        OrderStatisticsUtil.prices(SoldPizzasUtil.getPizzasPrices())).get(4)));
    }

    @Test
    public void totalRevenue() {
        putToMap();
        assertEquals(1282.32, OrderStatisticsUtil.totalRevenue(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices()));
    }

    @Test
    public void averageCheck() {
        putToMap();
        assertEquals(30.53, OrderStatisticsUtil.averageCheck(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices()));
    }

    @Test
    public void totalCost() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(822.0, OrderStatisticsUtil.totalCost(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasCost()));
    }

    @Test
    public void totalProfit() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(202.21, OrderStatisticsUtil.totalProfit(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices(), SoldPizzasUtil.getPizzasCost()));
    }

    @Test
    public void profitMargin() {
        putToMap();
        SoldPizzasUtil.createMapOfPizzasPrices();
        SoldPizzasUtil.createMapOfPizzasCost();
        assertEquals(15.77, OrderStatisticsUtil.profitMargin(SoldPizzasUtil.getSoldPizzas(),
                SoldPizzasUtil.getPizzasPrices(), SoldPizzasUtil.getPizzasCost()));
    }
}
