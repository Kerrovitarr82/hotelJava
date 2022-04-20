package com.senla.hoteladmin.util;

public class IdCreatorForEntities {
    private Long numberOfRoomId = 0L;
    private Long numberOfGuestId = 0L;
    private Long numberOfMaintenanceId = 0L;

    public Long createId(IdCreatorEnum idCreatorEnum, Long repositorySize) {
        switch (idCreatorEnum) {
            case ROOM -> {
                if (numberOfRoomId < repositorySize) {
                    numberOfRoomId = repositorySize;
                } else {
                    numberOfRoomId++;
                }
                return numberOfRoomId;
            }
            case GUEST -> {
                if (numberOfGuestId < repositorySize) {
                    numberOfGuestId = repositorySize;
                } else {
                    numberOfGuestId++;
                }
                return numberOfGuestId;
            }
            case MAINTENANCE -> {
                if (numberOfMaintenanceId < repositorySize) {
                    numberOfMaintenanceId = repositorySize;
                } else {
                    numberOfMaintenanceId++;
                }
                return numberOfMaintenanceId;
            }
        }
        return -1L;
    }
}
