package com.peregud.pizza.service;

import java.util.List;

public class IngredientOrderCalculatorService extends OrderCalculatorService {

    public IngredientOrderCalculatorService(List<Double> order) {
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
