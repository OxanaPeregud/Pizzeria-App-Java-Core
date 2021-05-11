/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProfitUtil {

    public double profitPercentage(double expenses) {
        return expenses * 1.3;
    }
}
