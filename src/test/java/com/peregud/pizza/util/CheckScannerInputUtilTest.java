/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class CheckScannerInputUtilTest {

    @Test
    public void invalidInput() {
        assertEquals("Your input is invalid. You must enter a digit", CheckScannerInputUtil.invalidInput());
    }

    @Test
    public void testPrivateConstructor() {
        Class<CheckScannerInputUtil> clazz = null;
        try {
            clazz = CheckScannerInputUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
