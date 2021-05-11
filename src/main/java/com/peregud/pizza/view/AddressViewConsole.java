/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.dao.DAOAddress;
import com.peregud.pizza.dao.impl.DAOAddressSQLImpl;

import java.sql.SQLException;

public class AddressViewConsole implements AddressView {
    private final DAOAddress daoAddress = new DAOAddressSQLImpl();

    @Override
    public void addressStreet() {
        System.out.println("Enter street:");
    }

    @Override
    public void addressHouse() {
        System.out.println("Enter house:");
    }

    @Override
    public void addressApartment() {
        System.out.println("Enter apartment:");
    }

    @Override
    public void addressID() {
        System.out.println("Enter address ID:");
    }

    @Override
    public void displayAddressByID(int id) throws SQLException {
        if (daoAddress.get(id) != null) {
            System.out.println(daoAddress.get(id));
        } else {
            System.out.println("There is no address under entered ID");
        }
    }

    @Override
    public void setNewStreet() {
        System.out.println("Enter new street:");
    }

    @Override
    public void setNewHouse() {
        System.out.println("Enter new house:");
    }

    @Override
    public void setNewApartment() {
        System.out.println("Enter new apartment:");
    }

    @Override
    public void changedAddress() {
        System.out.println("Address has been changed");
    }

    @Override
    public void deleteAddress() {
        System.out.println("Address has been deleted");
    }

    @Override
    public void displayAllAddresses() throws SQLException {
        daoAddress.getAll().forEach(System.out::println);
    }

    @Override
    public void displayChoice() {
        System.out.println("Choose option:");
        System.out.println("1. Add new Address");
        System.out.println("2. Display Address by ID");
        System.out.println("3. Change Address");
        System.out.println("4. Delete Address");
        System.out.println("5. Display all Addresses");
        System.out.println("6. Exit address app");
    }

    @Override
    public void choiceException() {
        System.out.println("You need to enter a number from 1 to 6");
    }
}
