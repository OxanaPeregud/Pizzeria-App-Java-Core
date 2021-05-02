package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfitUtil {

    public static double profitPercentage(double expenses) { return expenses * 1.3; }

}
