package com.peregud.pizza.view;

import java.sql.SQLException;

public interface CustomerView {

    void customerFirstName();

    void customerLastName();

    void customerCard();

    void customerID();

    void displayCustomerByID(int id) throws SQLException;

    void setNewCard();

    void changedCard();

    void deleteCustomer();

    void displayAllCustomers() throws SQLException;

}
