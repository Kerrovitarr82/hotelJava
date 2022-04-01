package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Maintenance;

import java.util.Calendar;
import java.util.Set;

public interface MaintenanceService extends AbstractService<Maintenance> {
    void changePriceToMaintenance(Long maintenanceId, int newPrice);

    void addMaintenanceToGuest(Long maintenanceId, Long guestId, Calendar maintenanceDate);

    Set<Maintenance> getMaintenanceSortedByPrice();

    Set<Maintenance> getMaintenancesForGuestSortedByPriceThenByDate(Long guestId);
}
