package com.example.demo.model;

import java.util.Arrays;

public enum Currency {
    UAH, USD, EUR;

    public static Currency fromValue(String val) {
        return Arrays.stream(values())
                    .filter(c -> c.name().equalsIgnoreCase(val))
                    .findFirst()
                    .get();
    }

}
