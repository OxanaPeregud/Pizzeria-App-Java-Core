/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.PinException;
import com.peregud.pizza.view.CardPaymentView;
import com.peregud.pizza.view.CardPaymentViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.InputMismatchException;
import java.util.Scanner;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardPaymentUtil {
    private static final CardPaymentView CARD_PAYMENT_VIEW = new CardPaymentViewConsole();

    public static void enterPIN() {
        try {
            CARD_PAYMENT_VIEW.enterPIN();
            Scanner scan = new Scanner(System.in);
            int count = 0;
            int PIN = scan.nextInt();
            while (PIN != 0) {
                PIN = PIN / 10;
                count++;
            }
            if (count != 4) {
                CARD_PAYMENT_VIEW.invalidInput();
                enterPIN();
            } else {
                CARD_PAYMENT_VIEW.approvePayment();
            }
        } catch (InputMismatchException e) {
            try {
                throw new PinException();
            } catch (PinException ex) {
                ex.printStackTrace();
                CARD_PAYMENT_VIEW.pinException();
                enterPIN();
            }
        }
    }
}
