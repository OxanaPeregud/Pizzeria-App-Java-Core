package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.List;

public class OrderRepositoryFile implements OrderRepository {
    private static final String FILEPATH = String.valueOf(Paths.get("src", "main", "resources", "Orders.txt"));

    @Override
    public void orderInput(List<Order> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(FILEPATH))) {
            for (Order order : list) {
                oop.writeObject(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
