/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxUtilTest {

    @Test
    public void VAT() {
        assertEquals(20, TaxUtil.VAT(100));
    }

    @Test
    public void VATonRevenue() {
        assertEquals(20, TaxUtil.VATonRevenue(120));
    }

    @Test
    public void CorporateIncomeTax() {
        assertEquals(82, TaxUtil.CorporateIncomeTax(100));
    }
}
