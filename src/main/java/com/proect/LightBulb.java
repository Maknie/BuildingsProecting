package com.proect;

public class LightBulb implements InRoomItem, Luminous {
    private int illuminanceLevel;

    public LightBulb(int illuminanceLevel) {
        this.illuminanceLevel = illuminanceLevel;
    }

    public int getIlluminanceLevel() {
        return illuminanceLevel;
    }
}
