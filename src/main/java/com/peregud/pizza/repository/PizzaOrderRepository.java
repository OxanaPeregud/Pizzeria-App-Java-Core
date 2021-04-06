package com.peregud.pizza.repository;

import java.util.List;

public class PizzaOrderRepository extends OrderRepository {

    public PizzaOrderRepository(List<Double> order) {
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
