/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import java.util.List;

public class PizzaOrderCalculatorService extends OrderCalculatorService {

    public PizzaOrderCalculatorService(List<Double> order) {
        super(order);
    }

    @Override
    public void add(double price) {
        super.add(price);
    }

    @Override
    public double totalOrder() {
        return super.totalOrder();
    }
}
