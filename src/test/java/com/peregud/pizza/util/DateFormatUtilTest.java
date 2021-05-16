/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatUtilTest {

    @Test
    void localDatePattern() {
        LocalDateTime localDate = LocalDateTime.of(2021, 5, 5, 9, 31, 15);
        assertEquals("05/05/2021 09:31:15", DateFormatUtil.localDatePattern(localDate));
    }

    @Test
    public void testPrivateConstructor() {
        Class<DateFormatUtil> clazz = null;
        try {
            clazz = DateFormatUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
