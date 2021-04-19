package com.peregud.pizza.repository;

import com.peregud.pizza.model.Order;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryFile implements OrderRepository {
    private static final String FILEPATH;

    static {
        FILEPATH = String.valueOf(Paths.get("src", "main", "resources", "Orders.txt"));
    }

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

    @Override
    public List<Order> orderOutput() {
        List<Order> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(FILEPATH);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Order order = (Order) ois.readObject();
                list.add(order);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
