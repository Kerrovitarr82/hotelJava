package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Maintenance;

import java.util.Calendar;
import java.util.Set;

public interface MaintenanceService extends AbstractService<Maintenance> {
    void changePriceToMaintenance(int maintenanceId, int newPrice);
    void addMaintenanceToGuest(int maintenanceId, int guestId, Calendar date);
    Set<Maintenance> maintenanceSort();
    Set<Maintenance> maintenancesForGuestSort(int guestId);
}
