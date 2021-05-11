/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.impl;

import com.peregud.pizza.dao.DAOOrder;
import com.peregud.pizza.model.Order;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DAOOrderFileImpl implements DAOOrder {
    private final String filepath = String.valueOf(Paths.get("src", "main", "resources", "Orders.txt"));

    @Override
    public void save(List<Order> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(filepath))) {
            for (Order order : list) {
                oop.writeObject(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Order order) {
    }

    @Override
    public Order get(Serializable id) {
        return null;
    }

    @Override
    public void update(Order order) {
    }

    @Override
    public void delete(Serializable id) {
    }

    @Override
    public List<Order> getAll() {
        List<Order> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
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
