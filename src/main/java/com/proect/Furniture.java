package com.proect;

public class Furniture implements InRoomItem {
    private String name;
    private float area;

    public Furniture(String name, int area) {
        this.area = area;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }
}
