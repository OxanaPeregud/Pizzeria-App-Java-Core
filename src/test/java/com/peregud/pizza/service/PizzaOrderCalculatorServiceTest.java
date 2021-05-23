package com.peregud.pizza.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderCalculatorServiceTest {
    List<Double> order = new ArrayList<>();
    PizzaOrderCalculatorService pizzaOrderCalculatorService =
            new PizzaOrderCalculatorService(order);

    @Test
    void add() {
        pizzaOrderCalculatorService.add(10);
        assertEquals(10, pizzaOrderCalculatorService.totalOrder());
    }
}
