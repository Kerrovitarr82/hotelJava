package com.senla.hoteladmin.ui.action.maintenance;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.ui.action.IAction;

import java.text.ParseException;

public class AddMaintenanceToGuestAction implements IAction {
    private MaintenanceController maintenanceController;

    public AddMaintenanceToGuestAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() throws ParseException {
        maintenanceController.addMaintenanceToGuest();
    }
}
