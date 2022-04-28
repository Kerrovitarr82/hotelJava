package com.senla.hoteladmin.util;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.dao.entity.Room;

public class IdCreatorForEntities {
    private Long numberOfRoomId = 0L;
    private Long numberOfGuestId = 0L;
    private Long numberOfMaintenanceId = 0L;

    public Long createId(Class entityClass, Long repositorySize) {
        if (Room.class.equals(entityClass)) {
            if (numberOfRoomId < repositorySize) {
                numberOfRoomId = repositorySize;
            } else {
                numberOfRoomId++;
            }
            return numberOfRoomId;
        } else if (Guest.class.equals(entityClass)) {
            if (numberOfGuestId < repositorySize) {
                numberOfGuestId = repositorySize;
            } else {
                numberOfGuestId++;
            }
            return numberOfGuestId;
        } else if (Maintenance.class.equals(entityClass)) {
            if (numberOfMaintenanceId < repositorySize) {
                numberOfMaintenanceId = repositorySize;
            } else {
                numberOfMaintenanceId++;
            }
            return numberOfMaintenanceId;
        }
        return -1L;
    }
}
