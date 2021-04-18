package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQL;
import com.peregud.pizza.view.*;

import java.util.HashMap;
import java.util.Map;

public final class PaymentChoiceUtil {
    private static final OrderRepository ORDER_REPOSITORY;
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    private static final CheckView CHECK_VIEW;
    private static final CashPaymentView CASH_PAYMENT_VIEW;

    static {
        ORDER_REPOSITORY = new OrderRepositorySQL();
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        CHECK_VIEW = new CheckViewConsole();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    private PaymentChoiceUtil() {
    }

    public static void paymentChoice() {
        ORDER_REPOSITORY.orderInput(OrderPizzaUtil.getOrderList());
        PIZZA_ORDER_VIEW.paymentChoice();
        try {
            int payment = CheckUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    CheckCreatorUtil.createCheck();
                    CashPaymentUtil.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangePizzaOrder();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    CheckCreatorUtil.createCheck();
                    CardPaymentUtil.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    CheckCreatorUtil.createCheck();
                    OnlinePaymentUtil.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                PIZZA_ORDER_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
