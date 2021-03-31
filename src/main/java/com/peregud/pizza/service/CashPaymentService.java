package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.CashAmountException;
import com.peregud.pizza.util.RoundUtil;
import com.peregud.pizza.view.CashPaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CashPaymentService {
    public static double fullAmount;
    private static final CashPaymentViewConsole CASH_PAYMENT_VIEW;

    static {
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
    }

    public double countChange(double amountToPay) {
        if (fullAmount < amountToPay) {
            CASH_PAYMENT_VIEW.notEnoughMoney();
            getFullAmount();
        }
        return RoundUtil.up(fullAmount - amountToPay);
    }

    public void getFullAmount() {
        try {
            CASH_PAYMENT_VIEW.fullAmountView();
            Scanner scan = new Scanner(System.in);
            fullAmount = scan.nextDouble();
        } catch (InputMismatchException e) {
            try {
                throw new CashAmountException();
            } catch (CashAmountException ex) {
                CASH_PAYMENT_VIEW.cashAmountException();
                getFullAmount();
            }
        }
    }
}
