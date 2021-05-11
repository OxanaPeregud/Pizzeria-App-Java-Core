/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.CashAmountException;
import com.peregud.pizza.view.CashPaymentView;
import com.peregud.pizza.view.CashPaymentViewConsole;
import lombok.experimental.UtilityClass;

import java.util.InputMismatchException;
import java.util.Scanner;

@UtilityClass
public class CashPaymentUtil {
    public double fullAmount;
    private final CashPaymentView CASH_PAYMENT_VIEW = new CashPaymentViewConsole();

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
                ex.printStackTrace();
                CASH_PAYMENT_VIEW.cashAmountException();
                getFullAmount();
            }
        }
    }
}
