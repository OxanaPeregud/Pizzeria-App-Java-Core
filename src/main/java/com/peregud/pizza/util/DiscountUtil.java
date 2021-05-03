/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DiscountUtil {

    public static double discountForTwoItems(double totalOrder) { return totalOrder * 0.9; }

    public static double discountForThreeAndMoreItems(double totalOrder) { return totalOrder * 0.8; }

    public static double discountForOrderOnSpecificDay(double totalOrder) { return totalOrder * 0.85; }

    public static double amountToPayFor2PizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForTwoItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }

    public static double amountToPayFor3AndMorePizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForThreeAndMoreItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }
}