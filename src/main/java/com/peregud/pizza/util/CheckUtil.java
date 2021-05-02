package com.peregud.pizza.util;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckUtil {
    private static List<String> CHECK = new ArrayList<>();

    public static void add(String item) {
        CHECK.add(item);
    }

    public static List<String> getCheck() {
        return CHECK;
    }
}
