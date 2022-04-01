package com.senla.hoteladmin.util;

public class IdCreatorForEntities {
    private int numberOfRoomId = 0;
    private int numberOfGuestId = 0;
    private int numberOfMaintenanceId = 0;
    
    public int createId(IdCreatorEnum idCreatorEnum) {
        switch (idCreatorEnum) {
            case ROOM -> {
                numberOfRoomId++;
                return numberOfRoomId;
            }
            case GUEST -> {
                numberOfGuestId++;
                return numberOfGuestId;
            }
            case MAINTENANCE -> {
                numberOfMaintenanceId++;
                return numberOfMaintenanceId;
            }
        }
        return -1;
    }
}
