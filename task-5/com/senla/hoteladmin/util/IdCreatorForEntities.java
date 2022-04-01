package com.senla.hoteladmin.util;

public class IdCreatorForEntities {
    private Long numberOfRoomId = 0L;
    private Long numberOfGuestId = 0L;
    private Long numberOfMaintenanceId = 0L;

    public Long createId(IdCreatorEnum idCreatorEnum) {
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
        return -1L;
    }
}
