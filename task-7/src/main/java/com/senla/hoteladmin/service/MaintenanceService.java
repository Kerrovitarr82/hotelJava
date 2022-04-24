package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Maintenance;

import java.io.IOException;
import java.util.Calendar;
import java.util.stream.Stream;

public interface MaintenanceService extends AbstractService<Maintenance> {
    void changePriceToMaintenance(Long maintenanceId, int newPrice);

    void addMaintenanceToGuest(Long maintenanceId, Long guestId, Calendar maintenanceDate);

    Stream<Maintenance> getMaintenanceSortedByPrice();

    Stream<Maintenance> getMaintenancesForGuestSortedByPriceThenByDate(Long guestId);

    void maintenanceSerialization(String fileName) throws IOException;

    void maintenanceDeserialization(String fileName) throws IOException, ClassNotFoundException;
}
