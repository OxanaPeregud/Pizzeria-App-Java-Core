package com.peregud.pizza.service;

import com.peregud.pizza.model.Address;
import com.peregud.pizza.repository.AddressRepository;
import com.peregud.pizza.repository.AddressRepositorySQLImpl;
import com.peregud.pizza.view.AddressView;
import com.peregud.pizza.view.AddressViewConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class AddressService implements DBData {
    private static final AddressView ADDRESS_VIEW;
    private static final Scanner SCAN;
    private static final AddressRepository ADDRESS_REPOSITORY;
    private final Address address = new Address();

    static {
        ADDRESS_VIEW = new AddressViewConsole();
        SCAN = new Scanner(System.in);
        ADDRESS_REPOSITORY = new AddressRepositorySQLImpl();
    }

    @Override
    public void saveNewData() {
        try {
            ADDRESS_VIEW.addressStreet();
            String street = SCAN.nextLine();
            ADDRESS_VIEW.addressHouse();
            int house = SCAN.nextInt();
            ADDRESS_VIEW.addressApartment();
            int apartment = SCAN.nextInt();
            ADDRESS_REPOSITORY.save(new Address(street, house, apartment));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID() {
        try {
            ADDRESS_VIEW.addressID();
            int id = SCAN.nextInt();
            ADDRESS_VIEW.displayAddressByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            ADDRESS_VIEW.addressID();
            int id = SCAN.nextInt();
            ADDRESS_VIEW.displayAddressByID(id);
            ADDRESS_VIEW.setNewStreet();
            String street = SCAN.nextLine();
            ADDRESS_VIEW.setNewHouse();
            int house = SCAN.nextInt();
            ADDRESS_VIEW.setNewApartment();
            int apartment = SCAN.nextInt();
            address.setStreet(street);
            address.setHouse(house);
            address.setApartment(apartment);
            address.setId(id);
            ADDRESS_REPOSITORY.update(address);
            ADDRESS_VIEW.changedAddress();
            ADDRESS_VIEW.displayAddressByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            ADDRESS_VIEW.addressID();
            int id = SCAN.nextInt();
            ADDRESS_REPOSITORY.delete(id);
            ADDRESS_VIEW.deleteAddress();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            ADDRESS_VIEW.displayAllAddresses();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
