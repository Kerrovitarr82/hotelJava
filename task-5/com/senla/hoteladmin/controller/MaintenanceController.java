package com.senla.hoteladmin.controller;

import java.text.ParseException;

public interface MaintenanceController extends ControllerInterface {
    void createMaintenance();

    void changePriceToMaintenance();

    void addMaintenanceToGuest() throws ParseException;

    void getMaintenanceSortedByPrice();

    void getMaintenancesForGuestSortedByPriceByDate();
}
