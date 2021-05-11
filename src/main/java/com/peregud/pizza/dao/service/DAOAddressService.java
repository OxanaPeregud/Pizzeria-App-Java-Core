/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.service;

import com.peregud.pizza.model.Address;
import com.peregud.pizza.dao.DAOAddress;
import com.peregud.pizza.dao.impl.DAOAddressSQLImpl;
import com.peregud.pizza.view.AddressView;
import com.peregud.pizza.view.AddressViewConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class DAOAddressService implements DBDataService {
    private final AddressView addressView = new AddressViewConsole();
    private final Scanner scan = new Scanner(System.in);
    private final DAOAddress daoAddress = new DAOAddressSQLImpl();
    private final Address address = new Address();

    @Override
    public void saveNewData() {
        try {
            addressView.addressStreet();
            String street = scan.nextLine();
            addressView.addressHouse();
            int house = scan.nextInt();
            addressView.addressApartment();
            int apartment = scan.nextInt();
            new Address();
            daoAddress.save(Address.builder()
                    .street(street)
                    .house(house)
                    .apartment(apartment)
                    .build());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID() {
        try {
            addressView.addressID();
            int id = scan.nextInt();
            addressView.displayAddressByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            addressView.addressID();
            int id = scan.nextInt();
            addressView.displayAddressByID(id);
            addressView.setNewStreet();
            String street = scan.nextLine();
            addressView.setNewHouse();
            int house = scan.nextInt();
            addressView.setNewApartment();
            int apartment = scan.nextInt();
            address.setStreet(street);
            address.setHouse(house);
            address.setApartment(apartment);
            address.setId(id);
            daoAddress.update(address);
            addressView.changedAddress();
            addressView.displayAddressByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            addressView.addressID();
            int id = scan.nextInt();
            daoAddress.delete(id);
            addressView.deleteAddress();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            addressView.displayAllAddresses();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
