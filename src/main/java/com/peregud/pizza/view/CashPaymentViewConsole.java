package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.CashAmountException;
import com.peregud.pizza.util.CashPaymentUtil;
import com.peregud.pizza.service.CreatePizzaService;
import com.peregud.pizza.service.PizzaOrderService;

public class CashPaymentViewConsole implements CashPaymentView {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;
    private static final CashAmountException CASH_AMOUNT_EXCEPTION;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        CREATE_PIZZA = new CreatePizzaService();
        CASH_AMOUNT_EXCEPTION = new CashAmountException();
    }

    @Override
    public void fullAmountView() {
        System.out.println("Enter amount of money you want to get the change from:");
    }

    @Override
    public void getChangePizzaOrder() {
        if (PIZZA_ORDER.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentUtil.fullAmount + "$ is "
                    + PIZZA_ORDER.getChange() + "$");
    }

    @Override
    public void getChangeCreatePizza() {
        if (CREATE_PIZZA.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentUtil.fullAmount + "$ is "
                    + CREATE_PIZZA.getChange() + "$");
    }

    @Override
    public void notEnoughMoney() {
        System.out.println("The amount is not enough to pay");
    }

    @Override
    public void cashAmountException() {
        System.out.println(CASH_AMOUNT_EXCEPTION.toString());
    }
}
