package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.CardException;
import com.peregud.pizza.model.Customer;
import com.peregud.pizza.repository.CustomerRepository;
import com.peregud.pizza.repository.CustomerRepositorySQLImpl;
import com.peregud.pizza.util.OrderPizzaUtil;
import com.peregud.pizza.view.CustomerView;
import com.peregud.pizza.view.CustomerViewConsole;
import com.peregud.pizza.view.OnlinePaymentView;
import com.peregud.pizza.view.OnlinePaymentViewConsole;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService implements DBData {
    private static final CustomerView CUSTOMER_VIEW;
    private static final Scanner SCAN;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private final Customer customer = new Customer();
    private static final OnlinePaymentView ONLINE_PAYMENT_VIEW;

    static {
        CUSTOMER_VIEW = new CustomerViewConsole();
        SCAN = new Scanner(System.in);
        CUSTOMER_REPOSITORY = new CustomerRepositorySQLImpl();
        ONLINE_PAYMENT_VIEW = new OnlinePaymentViewConsole();
    }

    @Override
    public void saveNewData() {
        try {
            CUSTOMER_VIEW.customerFirstName();
            String firstName = SCAN.next();
            CUSTOMER_VIEW.customerLastName();
            String lastName = SCAN.next();
            CUSTOMER_VIEW.customerCard();
            String cardNumber = SCAN.next();
            int count = 0;
            for (int i = 0; i < cardNumber.length(); i++) {
                count++;
            }
            if (count != 16) {
                ONLINE_PAYMENT_VIEW.invalidInput();
                saveNewData();
            } else {
                ONLINE_PAYMENT_VIEW.displayPayment();
            }
            new Customer();
            for (int i = 0; i < OrderPizzaUtil.getORDER_ID().size(); i++) {
                CUSTOMER_REPOSITORY.save(Customer.builder()
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
                ONLINE_PAYMENT_VIEW.cardException();
                saveNewData();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID() {
        try {
            CUSTOMER_VIEW.customerID();
            int id = SCAN.nextInt();
            CUSTOMER_VIEW.displayCustomerByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            CUSTOMER_VIEW.customerID();
            int id = SCAN.nextInt();
            CUSTOMER_VIEW.displayCustomerByID(id);
            CUSTOMER_VIEW.setNewCard();
            String card = SCAN.next();
            customer.setCardNumber(card);
            customer.setId(id);
            CUSTOMER_REPOSITORY.update(customer);
            CUSTOMER_VIEW.changedCard();
            CUSTOMER_VIEW.displayCustomerByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            CUSTOMER_VIEW.customerID();
            int id = SCAN.nextInt();
            CUSTOMER_REPOSITORY.delete(id);
            CUSTOMER_VIEW.deleteCustomer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            CUSTOMER_VIEW.displayAllCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
