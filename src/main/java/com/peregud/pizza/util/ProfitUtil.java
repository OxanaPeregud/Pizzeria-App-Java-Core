package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProfitUtil {

    public static double profitPercentage(double expenses) { return expenses * 1.3; }

}
