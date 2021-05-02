package com.peregud.pizza.util;

import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckScannerInputUtil {
    private static final UtilView UTIL_VIEW;

    static {
        UTIL_VIEW = new UtilViewConsole();
    }

    public static int checkInt() {
        Scanner scanner = new Scanner(System.in);
        int enteredInt;
        do {
            while (!scanner.hasNextInt()) {
                invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }

    public static double checkDouble() {
        Scanner scanner = new Scanner(System.in);
        double enteredDouble;
        while (!scanner.hasNextDouble()) {
            invalidInput();
            scanner.next();
        }
        enteredDouble = scanner.nextDouble();
        return enteredDouble;
    }

    public static void invalidInput() {
        UTIL_VIEW.checkUtilView();
    }
}
