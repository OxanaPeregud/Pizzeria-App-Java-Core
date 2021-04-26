package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.view.*;

import java.util.HashMap;
import java.util.Map;

public final class PaymentChoiceUtil {
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    private static final CashPaymentView CASH_PAYMENT_VIEW;
    private static final PaymentView PAYMENT_VIEW;

    static {
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        PAYMENT_VIEW = new PaymentViewConsole();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    private PaymentChoiceUtil() {
    }

    public static void paymentChoice() {
        PAYMENT_VIEW.paymentChoice();
        try {
            int payment = CheckScannerInputUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CashPaymentUtil.getFullAmount();
                    CASH_PAYMENT_VIEW.getChange();
                    break;
                case CARD:
                    CardPaymentUtil.enterPIN();
                    break;
                case ONLINE:
                    OnlinePaymentUtil.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                ex.printStackTrace();
                PAYMENT_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
