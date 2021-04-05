package com.peregud.pizza.util;

import com.peregud.pizza.exceptions.PinException;
import com.peregud.pizza.view.CardPaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CardPaymentUtil {
    private static final CardPaymentViewConsole CARD_PAYMENT_VIEW;

    static {
        CARD_PAYMENT_VIEW = new CardPaymentViewConsole();
    }

    private CardPaymentUtil() {
    }

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
                CARD_PAYMENT_VIEW.pinException();
                enterPIN();
            }
        }
    }
}
