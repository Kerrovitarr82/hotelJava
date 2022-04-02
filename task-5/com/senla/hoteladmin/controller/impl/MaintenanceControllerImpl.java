package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.UtilReader;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MaintenanceControllerImpl implements MaintenanceController {
    private RoomService roomService;
    private GuestService guestService;
    private MaintenanceService maintenanceService;
    private UtilReader utilReader = new UtilReader();

    public MaintenanceControllerImpl(RoomService roomService, GuestService guestService, MaintenanceService maintenanceService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.maintenanceService = maintenanceService;
    }

    @Override
    public void createMaintenance() {
        Maintenance maintenance = new Maintenance();
        System.out.print("������� �������� ������: ");
        String name = utilReader.readLine();
        maintenance.setName(name);
        System.out.print("������� ���� ������: ");
        int price = utilReader.readInt();
        maintenance.setPrice(price);
        maintenanceService.create(maintenance, IdCreatorEnum.MAINTENANCE);
        System.out.println("������ �������!");
    }

    @Override
    public void changePriceToMaintenance() {
        System.out.print("������� id ������: ");
        Long id = utilReader.readLong();
        System.out.print("������� ����� ���� ������: ");
        int price = utilReader.readInt();
        maintenanceService.changePriceToMaintenance(id, price);
        System.out.println("���� ��������!");
    }

    @Override
    public void addMaintenanceToGuest() throws ParseException {
        System.out.print("������� id ������: ");
        Long idMaintenance = utilReader.readLong();
        System.out.print("������� id �����: ");
        Long idGuest = utilReader.readLong();
        System.out.print("������� ���� � ������� ��.��.����: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = utilReader.readLine();
        calendar.setTime(sdf.parse(str));
        maintenanceService.addMaintenanceToGuest(idMaintenance, idGuest, calendar);
        System.out.println("������ ��������� �����!");
    }

    @Override
    public void getMaintenanceSortedByPrice() {
        UtilityFunctions.printFunc(maintenanceService.getMaintenanceSortedByPrice());
    }

    @Override
    public void getMaintenancesForGuestSortedByPriceByDate() {
        System.out.print("������� id �����: ");
        Long id = utilReader.readLong();
        UtilityFunctions.printFunc(maintenanceService.getMaintenancesForGuestSortedByPriceThenByDate(id));
    }
}
