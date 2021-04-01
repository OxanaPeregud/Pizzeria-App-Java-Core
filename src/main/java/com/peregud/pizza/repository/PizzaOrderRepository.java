package com.peregud.pizza.repository;

import java.util.List;

public class PizzaOrderRepository extends OrderRepository {

    public PizzaOrderRepository(List<Double> order) {
        super(order);
    }

    public void add(double price) {
        super.add(price);
    }

    public double totalOrder() {
        return super.totalOrder();
    }
}
