/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.types.PaymentMethod;
import com.peregud.pizza.view.CashPaymentView;
import com.peregud.pizza.view.CashPaymentViewConsole;
import com.peregud.pizza.view.PaymentView;
import com.peregud.pizza.view.PaymentViewConsole;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class PaymentChoiceUtil {
    private final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    private final CashPaymentView CASH_PAYMENT_VIEW;
    private final PaymentView PAYMENT_VIEW;

    static {
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        PAYMENT_VIEW = new PaymentViewConsole();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    public void paymentChoice() {
        PAYMENT_VIEW.paymentChoice();
        int payment = CheckScannerInputUtil.checkInt();
        if (PAYMENT_METHOD.get(payment) != null) {
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
        } else {
            PAYMENT_VIEW.paymentChoiceException();
            paymentChoice();
        }
    }
}
