package com.proect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Building {
    private Logger logger = LogManager.getLogger();
    private String name;
    private ArrayList<Room> roomsList = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public void addRoom(String roomName, int fullArea, int windowsQuantity) throws IlluminanceNotEnoughException, IlluminanceTooMuchException {
        roomsList.add(new Room(roomName, fullArea, windowsQuantity));
    }

    public Room getRoom(String roomName) {
        for (Room room : roomsList) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        throw new NotFoundSuchRoomException("There's no such room");
    }

    public void describe() {
        for (Room room : roomsList) {
            logger.info(name + ", ");
            room.describe();
        }
    }
}
