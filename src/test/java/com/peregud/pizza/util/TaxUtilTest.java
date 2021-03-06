/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

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

    @Test
    public void testPrivateConstructor() {
        Class<TaxUtil> clazz = null;
        try {
            clazz = TaxUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
