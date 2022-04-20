package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.PrettyPrinterUtil;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public class MaintenanceControllerImpl implements MaintenanceController {
    private RoomService roomService;
    private GuestService guestService;
    private MaintenanceService maintenanceService;

    public MaintenanceControllerImpl(RoomService roomService, GuestService guestService, MaintenanceService maintenanceService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.maintenanceService = maintenanceService;
    }

    @Override
    public void createMaintenance() {
        Maintenance maintenance = new Maintenance();
        System.out.print("¬ведите название услуги: ");
        String name = ReaderUtil.readLine();
        maintenance.setName(name);
        System.out.print("¬ведите цену услуги: ");
        int price = ReaderUtil.readInt();
        maintenance.setPrice(price);
        maintenanceService.create(maintenance);
        System.out.println("”слуга создана!");
    }

    @Override
    public void changePriceToMaintenance() {
        System.out.print("¬ведите id услуги: ");
        Long id = ReaderUtil.readLong();
        System.out.print("¬ведите новую цену услуги: ");
        int price = ReaderUtil.readInt();
        maintenanceService.changePriceToMaintenance(id, price);
        System.out.println("÷ена изменена!");
    }

    @Override
    public void addMaintenanceToGuest() throws ParseException {
        System.out.print("¬ведите id услуги: ");
        Long idMaintenance = ReaderUtil.readLong();
        System.out.print("¬ведите id гост€: ");
        Long idGuest = ReaderUtil.readLong();
        System.out.print("¬ведите дату в формате дд.мм.гггг: ");
        Calendar calendar = ReaderUtil.dateReadInDdMmYyyyFormat();
        maintenanceService.addMaintenanceToGuest(idMaintenance, idGuest, calendar);
        System.out.println("”слуга добавлена гостю!");
    }

    @Override
    public void getMaintenanceSortedByPrice() {
        maintenanceService.getMaintenanceSortedByPrice().forEach(System.out::println);
    }

    @Override
    public void getMaintenancesForGuestSortedByPriceByDate() {
        System.out.print("¬ведите id гост€: ");
        Long id = ReaderUtil.readLong();
        maintenanceService.getMaintenancesForGuestSortedByPriceThenByDate(id).forEach(System.out::println);
    }

    @Override
    public void getAll() {
        PrettyPrinterUtil.printFunc(maintenanceService.getAll());
    }

    @Override
    public void maintenanceSerialization() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("task-7/src/main/java/com/senla/hoteladmin/maintenanceSave.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(maintenanceService.getAll());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void maintenanceDeserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/java/com/senla/hoteladmin/maintenanceSave.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Maintenance> maintenances = (List<Maintenance>) objectInputStream.readObject();
        maintenanceService.setAll(maintenances);
        objectInputStream.close();
        fileInputStream.close();
    }
}
