package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        Maintenance maintenance = new Maintenance();
        System.out.print("¬ведите название услуги: ");
        String name = scanner.nextLine();
        maintenance.setName(name);
        System.out.print("¬ведите цену услуги: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        maintenance.setPrice(price);
        maintenanceService.create(maintenance, IdCreatorEnum.MAINTENANCE);
        System.out.println("”слуга создана!");
    }

    @Override
    public void changePriceToMaintenance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите id услуги: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("¬ведите новую цену услуги: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        maintenanceService.changePriceToMaintenance(id, price);
        System.out.println("÷ена изменена!");
    }

    @Override
    public void addMaintenanceToGuest() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите id услуги: ");
        Long idMaintenance = scanner.nextLong();
        scanner.nextLine();
        System.out.print("¬ведите id гост€: ");
        Long idGuest = scanner.nextLong();
        scanner.nextLine();
        System.out.print("¬ведите дату в формате дд.мм.гггг: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = scanner.nextLine();
        calendar.setTime(sdf.parse(str));
        maintenanceService.addMaintenanceToGuest(idMaintenance, idGuest, calendar);
        System.out.println("”слуга добавлена гостю!");
    }

    @Override
    public void getMaintenanceSortedByPrice() {
        UtilityFunctions.printFunc(maintenanceService.getMaintenanceSortedByPrice());
    }

    @Override
    public void getMaintenancesForGuestSortedByPriceByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите id гост€: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        UtilityFunctions.printFunc(maintenanceService.getMaintenancesForGuestSortedByPriceThenByDate(id));
    }
}
