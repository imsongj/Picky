package com.picky.business.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Badge {
    ONE_PLUS_ONE("one_plus_one"),
    TWO_PLUS_ONE("two_plus_two");

    private final String value;
    Badge(String value) {
        this.value = value;
    }
    @JsonCreator
    public static Badge fromValue(String value) {
        for (Badge badge : values()) {
            if (badge.value.equals(value)) {
                return badge;
            }
        }
        throw new IllegalArgumentException("Invalid Badge value: " + value);
    }
}
