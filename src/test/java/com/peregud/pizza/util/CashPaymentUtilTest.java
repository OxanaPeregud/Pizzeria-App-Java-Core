package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashPaymentUtilTest {

    @Test
    public void countChange() {
        CashPaymentUtil.fullAmount = 250;
        assertEquals(150, CashPaymentUtil.countChange(100));
    }
}
