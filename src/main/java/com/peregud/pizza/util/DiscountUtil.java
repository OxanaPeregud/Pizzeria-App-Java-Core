/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DiscountUtil {

    public double discountForTwoItems(double totalOrder) {
        return totalOrder * 0.9;
    }

    public double discountForThreeAndMoreItems(double totalOrder) {
        return totalOrder * 0.8;
    }

    public double discountForOrderOnSpecificDay(double totalOrder) {
        return totalOrder * 0.85;
    }

    public double amountToPayFor2PizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForTwoItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }

    public double amountToPayFor3AndMorePizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForThreeAndMoreItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }
}
