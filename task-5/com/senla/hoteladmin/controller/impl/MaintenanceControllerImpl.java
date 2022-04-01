package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorForEntities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MaintenanceControllerImpl implements MaintenanceController {
    private RoomService roomService;
    private GuestService guestService;
    private MaintenanceService maintenanceService;
    private IdCreatorForEntities idCreator;

    public MaintenanceControllerImpl(RoomService roomService, GuestService guestService, MaintenanceService maintenanceService, IdCreatorForEntities idCreator) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.maintenanceService = maintenanceService;
        this.idCreator = idCreator;
    }

    @Override
    public void changePriceToMaintenance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id услуги: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите новую цену услуги: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        maintenanceService.changePriceToMaintenance(id, price);
        System.out.println("Цена изменена!");
    }

    @Override
    public void addMaintenanceToGuest() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id услуги: ");
        int idMaintenance = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите id гостя: ");
        int idGuest = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите дату в формате дд.мм.гггг: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = scanner.nextLine();
        calendar.setTime(sdf.parse(str));
        maintenanceService.addMaintenanceToGuest(idMaintenance, idGuest, calendar);
        System.out.println("Услуга добавлена гостю!");
    }

    @Override
    public void maintenanceSort() {
        for (Maintenance maintenance : maintenanceService.maintenanceSort()) {
            System.out.println(maintenance);
        }
    }

    @Override
    public void maintenancesForGuestSort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id гостя: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Maintenance maintenance : maintenanceService.maintenancesForGuestSort(id)) {
            System.out.println(maintenance);
        }
    }
}
