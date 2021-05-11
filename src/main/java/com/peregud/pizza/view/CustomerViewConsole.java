/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.dao.DAOCustomer;
import com.peregud.pizza.dao.impl.DAOCustomerSQLImpl;

import java.sql.SQLException;

public class CustomerViewConsole implements CustomerView {
    private final DAOCustomer DAOCustomer = new DAOCustomerSQLImpl();

    @Override
    public void customerFirstName() {
        System.out.println("Enter First Name:");
    }

    @Override
    public void customerLastName() {
        System.out.println("Enter Last Name:");
    }

    @Override
    public void customerCard() {
        System.out.println("Enter card number:");
    }

    @Override
    public void customerID() {
        System.out.println("Enter customer ID:");
    }

    @Override
    public void displayCustomerByID(int id) throws SQLException {
        if (DAOCustomer.get(id) != null) {
            System.out.println(DAOCustomer.get(id));
        } else {
            System.out.println("There is no Customer under entered ID");
        }
    }

    @Override
    public void setNewCard() {
        System.out.println("Enter new card number:");
    }

    @Override
    public void changedCard() {
        System.out.println("Customer card number has been changed");
    }

    @Override
    public void deleteCustomer() {
        System.out.println("Customer has been deleted");
    }

    @Override
    public void displayAllCustomers() throws SQLException {
        DAOCustomer.getAll().forEach(System.out::println);
    }
}
