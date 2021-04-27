package com.peregud.pizza.view;

import com.peregud.pizza.repository.AddressRepository;
import com.peregud.pizza.repository.AddressRepositorySQLImpl;

import java.sql.SQLException;

public class AddressViewConsole implements AddressView {
    private static final AddressRepository ADDRESS_REPOSITORY;

    static {
        ADDRESS_REPOSITORY = new AddressRepositorySQLImpl();
    }

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
        if (ADDRESS_REPOSITORY.get(id) != null) {
            System.out.println(ADDRESS_REPOSITORY.get(id));
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
        ADDRESS_REPOSITORY.getAll().forEach(System.out::println);
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
