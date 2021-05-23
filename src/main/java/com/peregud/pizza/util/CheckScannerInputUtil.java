/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.view.UtilView;
import com.peregud.pizza.view.UtilViewConsole;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

@UtilityClass
public class CheckScannerInputUtil {
    private final UtilView UTIL_VIEW = new UtilViewConsole();

    public int checkInt() {
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

    public double checkDouble() {
        Scanner scanner = new Scanner(System.in);
        double enteredDouble;
        while (!scanner.hasNextDouble()) {
            invalidInput();
            scanner.next();
        }
        enteredDouble = scanner.nextDouble();
        return enteredDouble;
    }

    public String invalidInput() {
        return UTIL_VIEW.checkUtilView();
    }
}
