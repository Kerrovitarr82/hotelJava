package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.util.MaintenanceDateComparator;
import com.senla.hoteladmin.util.MaintenancePriceComparator;

import java.util.Calendar;
import java.util.Comparator;
import java.util.stream.Stream;

public class MaintenanceServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements MaintenanceService {
    private RoomDao roomDao;
    private GuestDao guestDao;
    private MaintenanceDao maintenanceDao;

    public MaintenanceServiceImpl(MaintenanceDao defaultDao, RoomDao roomDao, GuestDao guestDao, MaintenanceDao maintenanceDao) {
        super(defaultDao);
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public void changePriceToMaintenance(Long maintenanceId, int newPrice) {
        Maintenance maintenance = maintenanceDao.getById(maintenanceId);
        maintenance.setPrice(newPrice);
    }

    @Override
    public void addMaintenanceToGuest(Long maintenanceId, Long guestId, Calendar maintenanceDate) {
        Maintenance maintenance = maintenanceDao.getById(maintenanceId);
        Guest guest = guestDao.getById(guestId);
        guest.addMaintenances(new Maintenance(maintenance.getName(), maintenance.getPrice(), maintenanceId, maintenanceDate));
    }

    @Override
    public Stream<Maintenance> getMaintenanceSortedByPrice() {
        Comparator<Maintenance> maintenanceComparator = new MaintenancePriceComparator();
        return maintenanceDao.getAll().stream().sorted(maintenanceComparator);
    }

    @Override
    public Stream<Maintenance> getMaintenancesForGuestSortedByPriceThenByDate(Long guestId) {
        Comparator<Maintenance> maintenanceComparator = new MaintenancePriceComparator().thenComparing(new MaintenanceDateComparator());
        Guest guest = guestDao.getById(guestId);
        return guest.getMaintenances().stream().sorted(maintenanceComparator);
    }
}
