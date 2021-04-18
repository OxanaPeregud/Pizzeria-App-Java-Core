package com.peregud.pizza.service;

import java.util.List;

public class OrderCalculatorService {
    private final List<Double> order;

    public OrderCalculatorService(List<Double> order) {
        this.order = order;
    }

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

