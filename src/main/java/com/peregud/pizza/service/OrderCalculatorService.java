/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderCalculatorService {
    private final List<Double> order;

    public void add(double price) {
        order.add(price);
    }

    public double totalOrder() {
        return order.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int size() {
        return order.size();
    }
}
