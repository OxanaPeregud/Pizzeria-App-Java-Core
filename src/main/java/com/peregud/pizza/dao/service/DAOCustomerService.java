/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.service;

import com.peregud.pizza.exceptions.CardException;
import com.peregud.pizza.model.Customer;
import com.peregud.pizza.dao.DAOCustomer;
import com.peregud.pizza.dao.impl.DAOCustomerSQLImpl;
import com.peregud.pizza.util.OrderPizzaUtil;
import com.peregud.pizza.view.CustomerView;
import com.peregud.pizza.view.CustomerViewConsole;
import com.peregud.pizza.view.OnlinePaymentView;
import com.peregud.pizza.view.OnlinePaymentViewConsole;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DAOCustomerService implements DBDataService {
    private final CustomerView customerView = new CustomerViewConsole();
    private final Scanner scan = new Scanner(System.in);
    private final DAOCustomer daoCustomer = new DAOCustomerSQLImpl();
    private final Customer customer = new Customer();
    private final OnlinePaymentView onlinePaymentView = new OnlinePaymentViewConsole();

    @Override
    public void saveNewData() {
        try {
            customerView.customerFirstName();
            String firstName = scan.next();
            customerView.customerLastName();
            String lastName = scan.next();
            customerView.customerCard();
            String cardNumber = scan.next();
            int count = 0;
            for (int i = 0; i < cardNumber.length(); i++) {
                count++;
            }
            if (count != 16) {
                onlinePaymentView.invalidInput();
                saveNewData();
            } else {
                onlinePaymentView.displayPayment();
            }
            new Customer();
            for (int i = 0; i < OrderPizzaUtil.getORDER_ID().size(); i++) {
                daoCustomer.save(Customer.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .cardNumber(cardNumber)
                        .orderID(OrderPizzaUtil.getORDER_ID().get(i))
                        .build());
            }
        } catch (InputMismatchException e) {
            try {
                throw new CardException();
            } catch (CardException ex) {
                ex.printStackTrace();
                onlinePaymentView.cardException();
                saveNewData();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID() {
        try {
            customerView.customerID();
            int id = scan.nextInt();
            customerView.displayCustomerByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            customerView.customerID();
            int id = scan.nextInt();
            customerView.displayCustomerByID(id);
            customerView.setNewCard();
            String card = scan.next();
            customer.setCardNumber(card);
            customer.setId(id);
            daoCustomer.update(customer);
            customerView.changedCard();
            customerView.displayCustomerByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            customerView.customerID();
            int id = scan.nextInt();
            daoCustomer.delete(id);
            customerView.deleteCustomer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            customerView.displayAllCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
