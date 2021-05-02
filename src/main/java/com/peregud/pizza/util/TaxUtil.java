package com.peregud.pizza.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaxUtil {

    public static double VAT(double priceWithoutVAT) { return priceWithoutVAT * 0.2; }

    public static double VATonRevenue(double revenue) { return revenue * 20 / 120; }

    public static double CorporateIncomeTax(double profit) { return profit * 0.82; }

}
