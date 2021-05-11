/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CheckUtil {
    private final List<String> CHECK = new ArrayList<>();

    public void add(String item) {
        CHECK.add(item);
    }

    public List<String> getCheck() {
        return CHECK;
    }
}
