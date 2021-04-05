package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.CashAmountException;
import com.peregud.pizza.view.CashPaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CashPaymentUtil {
    public static double fullAmount;
    private static final CashPaymentViewConsole CASH_PAYMENT_VIEW;

    static {
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
    }

    private CashPaymentUtil() {
    }

    public static double countChange(double amountToPay) {
        if (fullAmount < amountToPay) {
            CASH_PAYMENT_VIEW.notEnoughMoney();
            getFullAmount();
        }
        return RoundUtil.up(fullAmount - amountToPay);
    }

    public static void getFullAmount() {
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
