package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.CardException;
import com.peregud.pizza.model.Customer;
import com.peregud.pizza.view.OnlinePaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlinePaymentService {
    private static final OnlinePaymentViewConsole ONLINE_PAYMENT_VIEW;

    static {
        ONLINE_PAYMENT_VIEW = new OnlinePaymentViewConsole();
    }

    public void addCustomer() {
        Scanner scan = new Scanner(System.in);
        ONLINE_PAYMENT_VIEW.firstName();
        Customer.firstName = scan.next();
        ONLINE_PAYMENT_VIEW.lastName();
        Customer.lastName = scan.next();
        ONLINE_PAYMENT_VIEW.cardNumber();
        enterCardNumber();
    }

    public void enterCardNumber() {
        try {
            int count = 0;
            Scanner scan = new Scanner(System.in);
            Customer.cardNumber = scan.nextLong();
            while (Customer.cardNumber != 0) {
                Customer.cardNumber = Customer.cardNumber / 10;
                count++;
            }
            if (count != 16) {
                ONLINE_PAYMENT_VIEW.invalidInput();
                ONLINE_PAYMENT_VIEW.cardNumber();
                enterCardNumber();
            } else {
                ONLINE_PAYMENT_VIEW.displayPayment();
            }
        } catch (InputMismatchException e) {
            try {
                throw new CardException();
            } catch (CardException ex) {
                ONLINE_PAYMENT_VIEW.cardException();
                ONLINE_PAYMENT_VIEW.cardNumber();
                enterCardNumber();
            }
        }
    }
}
