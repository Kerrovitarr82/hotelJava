package com.senla.hoteladmin.ui.action;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.RoomController;

import java.io.IOException;

public class SerializationAction implements IAction {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;

    public SerializationAction(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() throws IOException {
        roomController.roomSerialization();
        guestController.guestSerialization();
        maintenanceController.maintenanceSerialization();
    }
}
