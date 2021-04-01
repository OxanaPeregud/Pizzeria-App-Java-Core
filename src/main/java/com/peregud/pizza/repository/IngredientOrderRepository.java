package com.peregud.pizza.repository;

import java.util.List;

public class IngredientOrderRepository extends OrderRepository {

    public IngredientOrderRepository(List<Double> order) {
        super(order);
    }

    public void add(double price) {
        super.add(price);
    }

    public double totalOrder() {
        return super.totalOrder();
    }
}
