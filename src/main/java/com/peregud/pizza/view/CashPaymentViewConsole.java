package com.peregud.pizza.view;

import com.peregud.pizza.util.CashPaymentUtil;
import com.peregud.pizza.util.ChangeCalculatorUtil;

public class CashPaymentViewConsole implements CashPaymentView {

    @Override
    public void fullAmountView() {
        System.out.println("Enter amount of money you want to get the change from:");
    }

    @Override
    public void getChange() {
        if (ChangeCalculatorUtil.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentUtil.fullAmount + "$ is "
                    + ChangeCalculatorUtil.getChange() + "$");
    }

    @Override
    public void notEnoughMoney() {
        System.out.println("The amount is not enough to pay");
    }

    @Override
    public void cashAmountException() {
        System.out.println("Cash amount must be a number");
    }
}
