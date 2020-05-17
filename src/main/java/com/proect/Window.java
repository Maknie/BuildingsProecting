package com.proect;

public class Window implements Luminous {
    private int illuminanceLevel;

    public Window() {
        illuminanceLevel = ConstValuesEnum.WINDOW_ILLUMINANCE.getValue();
    }

    public int getIlluminanceLevel() {
        return illuminanceLevel;
    }
}
