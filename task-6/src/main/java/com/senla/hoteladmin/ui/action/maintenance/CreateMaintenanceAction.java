package com.senla.hoteladmin.ui.action.maintenance;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.ui.action.IAction;

public class CreateMaintenanceAction implements IAction {
    private MaintenanceController maintenanceController;

    public CreateMaintenanceAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() {
        maintenanceController.createMaintenance();
    }
}
