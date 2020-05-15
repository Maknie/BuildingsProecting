package com.proect;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\Lord\\IdeaProjects\\BuildingProecting\\src\\main\\resources\\log4j.xml");
        Logger logger = LogManager.getLogger();
        Building building = new Building("Building 1");
        try {
            building.addRoom("Room 1", 100, 3);
            building.addRoom("Room 2", 150, 4);
            building.getRoom("Room 1").add(new LightBulb(150));
            building.getRoom("Room 1").add(new LightBulb(450));
            building.getRoom("Room 1").add(new Furniture("Work table", 15));
            building.getRoom("Room 1").add(new Furniture("Bed", 25));
            building.getRoom("Room 2").add(new LightBulb(250));
            building.getRoom("Room 2").add(new LightBulb(50));
            building.getRoom("Room 2").add(new Furniture("Couch", 35));
            building.getRoom("Room 2").add(new Furniture("Armchair", 15));
        } catch (IlluminanceTooMuchException e) {
            e.printStackTrace();
        } catch (IlluminanceNotEnoughException e) {
            e.printStackTrace();
        } catch (SpaceUsageTooMuchException e) {
            e.printStackTrace();
        }
        building.describe();
    }
}
