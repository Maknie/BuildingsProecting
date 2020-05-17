package com.project;

public enum ConstValuesEnum {
    MAX_ILLUMINANCE(4000),
    MIN_ILLUMINANCE(300),
    WINDOW_ILLUMINANCE(700),
    MAX_ROOM_SPACE(70);

    private final int value;

    ConstValuesEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
