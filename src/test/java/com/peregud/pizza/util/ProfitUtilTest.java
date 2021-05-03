/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitUtilTest {

    @Test
    public void profitPercentage() {
        assertEquals(130, ProfitUtil.profitPercentage(100));
    }
}
