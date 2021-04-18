package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;

import java.util.List;

public interface OrderRepository {

    void orderInput(List<Order> list);

}
