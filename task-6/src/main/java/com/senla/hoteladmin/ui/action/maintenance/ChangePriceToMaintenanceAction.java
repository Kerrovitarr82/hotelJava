package com.senla.hoteladmin.ui.action.maintenance;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.ui.action.IAction;

public class ChangePriceToMaintenanceAction implements IAction {
    private MaintenanceController maintenanceController;

    public ChangePriceToMaintenanceAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() {
        maintenanceController.changePriceToMaintenance();
    }
}
