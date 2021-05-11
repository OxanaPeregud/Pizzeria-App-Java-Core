/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TaxUtil {

    public double VAT(double priceWithoutVAT) {
        return priceWithoutVAT * 0.2;
    }

    public double VATonRevenue(double revenue) {
        return revenue * 20 / 120;
    }

    public double CorporateIncomeTax(double profit) {
        return profit * 0.82;
    }
}
