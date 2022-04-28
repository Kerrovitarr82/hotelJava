package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.controller.impl.SerializationControllerImpl;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.util.MaintenanceDateComparator;
import com.senla.hoteladmin.util.MaintenancePriceComparator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
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

    @Override
    public void maintenanceSerialization(String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(SerializationControllerImpl.PATH_TO_SER_FILE + fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(maintenanceDao.getAll());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void maintenanceDeserialization(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(SerializationControllerImpl.PATH_TO_SER_FILE + fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Maintenance> maintenances = (List<Maintenance>) objectInputStream.readObject();
        maintenanceDao.setAll(maintenances);
        objectInputStream.close();
        fileInputStream.close();
    }
}
