package com.peregud.pizza.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorServiceTest {
    OrderCalculatorService order = new OrderCalculatorService(new ArrayList<>());

    public void addToOrder() {
        order.add(100);
        order.add(150);
        order.add(200);
    }

    @Test
    public void totalOrder() {
        addToOrder();
        assertEquals(450, order.totalOrder());
    }

    @Test
    public void size_OrderRepository() {
        addToOrder();
        assertEquals(3, order.size());
    }
}
