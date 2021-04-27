package com.peregud.pizza.view;

import java.sql.SQLException;

public interface AddressView {

    void addressStreet();

    void addressHouse();

    void addressApartment();

    void addressID();

    void displayAddressByID(int id) throws SQLException;

    void setNewStreet();

    void setNewHouse();

    void setNewApartment();

    void changedAddress();

    void deleteAddress();

    void displayAllAddresses() throws SQLException;

    void displayChoice();

    void choiceException();

}
