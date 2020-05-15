package com.proect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Room {
    private Logger logger = LogManager.getLogger();
    private String name;
    private float fullArea;
    private float filledArea;
    private int windowsQuantity;
    private int illuminanceLevel;
    private ArrayList<InRoomItem> inRoomItemsList = new ArrayList<>();

    public Room(String name, float fullArea, int windowsQuantity) throws IlluminanceTooMuchException, IlluminanceNotEnoughException {

        this.name = name;
        this.fullArea = fullArea;
        this.filledArea = 0;
        this.windowsQuantity = windowsQuantity;
        addIlluminance(windowsQuantity * ConstValuesEnum.WINDOW_ILLUMINANCE.getValue());
    }

    public void getInRoomLightBulbs() {
        int count = 0;
        String lightBulbs = "";
        for (InRoomItem inRoomItem : inRoomItemsList) {
            if (inRoomItem instanceof LightBulb) {
                lightBulbs += " " + ((LightBulb) inRoomItem).getIlluminanceLevel() + "lx";
            } else
                count++;
            if (count == inRoomItemsList.size())
                lightBulbs = "There's no light bulbs.";
        }
        logger.info("(Light bulb: " + lightBulbs + ") ");
    }

    public void getInRoomFurniture() {
        int count = 0;
        String furniture = "";
        for (InRoomItem inRoomItem : inRoomItemsList) {
            if (inRoomItem instanceof Furniture) {
                furniture += ((Furniture) inRoomItem).getName() + " ";
                furniture += "(Area that takes " + ((Furniture) inRoomItem).getArea() + "m^2 ) ";
            } else
                count++;
            if (count == inRoomItemsList.size())
                furniture = "There's no furniture.";
        }
        logger.info("Furniture: " + furniture);
    }

    public void add(InRoomItem inRoomItem) throws IlluminanceTooMuchException, IlluminanceNotEnoughException, SpaceUsageTooMuchException {
        inRoomItemsList.add(inRoomItem);
        if (inRoomItem instanceof LightBulb) {
            addIlluminance(((LightBulb) inRoomItem).getIlluminanceLevel());
        } else if (inRoomItem instanceof Furniture) {
            addFurniture(((Furniture) inRoomItem).getArea());
        }
    }

    public void remove(InRoomItem inRoomItem) {
        inRoomItemsList.remove(inRoomItem);
        if (inRoomItem instanceof Furniture) {
            filledArea += ((Furniture) inRoomItem).getArea();
        } else if (inRoomItem instanceof LightBulb) {
            illuminanceLevel -= ((LightBulb) inRoomItem).getIlluminanceLevel();
        }

    }

    public void describe() {
        double percent = 100.0 - Math.floor(this.getFilledArea() / this.getFullArea() * 100);
        double freeSpace = this.getFullArea() - this.getFilledArea();
        logger.info(this.getName() + "\n");
        logger.info("Illuminance in room is " + this.getIlluminanceLevel() + ": ");
        logger.info("(" + this.getWindowsQuantity() + " windows, each makes " + ConstValuesEnum.WINDOW_ILLUMINANCE.getValue() + "lx )");
        this.getInRoomLightBulbs();
        logger.info("Area in room is " + this.getFullArea() + "( Filled: " + this.getFilledArea() + "m^2, " + "Free place area is " + freeSpace + "m^2 or " + percent + "% )");
        this.getInRoomFurniture();
        logger.info("That's it\n");
    }

    public void addIlluminance(int newIlluminance) throws IlluminanceNotEnoughException, IlluminanceTooMuchException {
        if (this.getIlluminanceLevel() + newIlluminance < ConstValuesEnum.MIN_ILLUMINANCE.getValue())
            throw new IlluminanceNotEnoughException();
        if (this.getIlluminanceLevel() + newIlluminance > ConstValuesEnum.MAX_ILLUMINANCE.getValue())
            throw new IlluminanceTooMuchException();
        illuminanceLevel += newIlluminance;
    }

    public void addFurniture(float furnitureArea) throws SpaceUsageTooMuchException {
        if (this.getFilledArea() + furnitureArea > ConstValuesEnum.MAX_ROOM_SPACE.getValue() * getFullArea() / 100)
            throw new SpaceUsageTooMuchException();
        this.filledArea += furnitureArea;
    }

    public int getIlluminanceLevel() {
        return illuminanceLevel;
    }

    public int getWindowsQuantity() {
        return windowsQuantity;
    }

    public String getName() {
        return name;
    }

    public float getFullArea() {
        return fullArea;
    }

    public float getFilledArea() {
        return filledArea;
    }

    public void setName(String name) {
        this.name = name;
    }
}
