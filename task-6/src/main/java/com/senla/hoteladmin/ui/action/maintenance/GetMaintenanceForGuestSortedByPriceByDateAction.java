package com.senla.hoteladmin.ui.action.maintenance;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.ui.action.IAction;

public class GetMaintenanceForGuestSortedByPriceByDateAction implements IAction {
    private MaintenanceController maintenanceController;

    public GetMaintenanceForGuestSortedByPriceByDateAction(MaintenanceController maintenanceController) {
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void execute() {
        maintenanceController.getMaintenancesForGuestSortedByPriceByDate();
    }
}
