package com.peregud.pizza.model;

import java.util.ArrayList;
import java.util.List;

public final class Check {
    private static final List<String> CHECK;

    static {
        CHECK = new ArrayList<>();
    }

    private Check() {
    }

    public static void add(String item) {
        CHECK.add(item);
    }

    public static List<String> getCheck() {
        return CHECK;
    }
}
