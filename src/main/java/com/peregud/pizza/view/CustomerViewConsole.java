/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.repository.CustomerRepository;
import com.peregud.pizza.repository.CustomerRepositorySQLImpl;

import java.sql.SQLException;

public class CustomerViewConsole implements CustomerView {
    private final CustomerRepository customerRepository = new CustomerRepositorySQLImpl();

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
        if (customerRepository.get(id) != null) {
            System.out.println(customerRepository.get(id));
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
        customerRepository.getAll().forEach(System.out::println);
    }
}
