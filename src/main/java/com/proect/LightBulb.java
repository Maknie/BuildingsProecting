package com.proect;

public class LightBulb implements InRoomItem {
    private int illuminanceLevel;

    public LightBulb(int illuminanceLevel) {
        this.illuminanceLevel = illuminanceLevel;
    }

    @Override
    public String toString() {
        return "LightBulb " +
                "name='" + this.getIlluminanceLevel() + "\'";
    }

    public int getIlluminanceLevel() {
        return illuminanceLevel;
    }
}
