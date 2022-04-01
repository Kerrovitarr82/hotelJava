package com.senla.hoteladmin;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.controller.impl.GuestControllerImpl;
import com.senla.hoteladmin.controller.impl.MaintenanceControllerImpl;
import com.senla.hoteladmin.controller.impl.RoomControllerImpl;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.impl.GuestDaoImpl;
import com.senla.hoteladmin.dao.impl.MaintenanceDaoImpl;
import com.senla.hoteladmin.dao.impl.RoomDaoImpl;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.service.impl.GuestServiceImpl;
import com.senla.hoteladmin.service.impl.MaintenanceServiceImpl;
import com.senla.hoteladmin.service.impl.RoomServiceImpl;
import com.senla.hoteladmin.util.IdCreatorForEntities;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        IdCreatorForEntities idCreatorForEntities = new IdCreatorForEntities();
        RoomDao roomDao = new RoomDaoImpl();
        GuestDao guestDao = new GuestDaoImpl();
        MaintenanceDao maintenanceDao = new MaintenanceDaoImpl();
        RoomService roomService = new RoomServiceImpl(roomDao, roomDao, guestDao, maintenanceDao);
        GuestService guestService = new GuestServiceImpl(guestDao, roomDao, guestDao, maintenanceDao);
        MaintenanceService maintenanceService = new MaintenanceServiceImpl(maintenanceDao, roomDao, guestDao, maintenanceDao);
        RoomController roomController = new RoomControllerImpl(roomService, guestService, idCreatorForEntities);
        GuestController guestController = new GuestControllerImpl(roomService, guestService, idCreatorForEntities);
        MaintenanceController maintenanceController = new MaintenanceControllerImpl(roomService, guestService, maintenanceService, idCreatorForEntities);

        boolean exitBool = true;
        boolean exitFromSectionBool = true;
        Scanner scanner = new Scanner(System.in);
        int mainSwitchChoice = 0;
        int sectionSwitchChoice = 0;
        while (exitBool) {
            System.out.println("\n�������� ��������");
            System.out.println("\n�������" +
                    "\n1) ������ �������" +
                    "\n2) ������ ������" +
                    "\n3) ������ �����" +
                    "\n4) �����");
            mainSwitchChoice = scanner.nextInt();
            scanner.nextLine();
            exitFromSectionBool = true;
            switch (mainSwitchChoice) {
                case 1:
                    while (exitFromSectionBool) {
                        System.out.println("\n������ �������" +
                                "\n1) ������� �����" +
                                "\n2) �������� ����� � �����" +
                                "\n3) ������� ������ �� ������" +
                                "\n4) �������� ������ ������" +
                                "\n5) �������� ���� ������" +
                                "\n6) ������� ����� ���-�� ��������� �������" +
                                "\n7) ������� ����� ���-�� ��������� ������� ����� ������������ ����" +
                                "\n8) ������� ������ � ������������� ����" +
                                "\n9) ������� ��������� ���� ������ ������" +
                                "\n10) ������� ������ ������" +
                                "\n11) �����");
                        sectionSwitchChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sectionSwitchChoice) {
                            case 1 -> roomController.createRoom();
                            case 2 -> roomController.addToRoom();
                            case 3 -> roomController.deleteFromRoom();
                            case 4 -> roomController.changeStatus();
                            case 5 -> roomController.changePriceToRoom();
                            case 6 -> roomController.totalNumberOfFreeRooms();
                            case 7 -> roomController.listOfFreeRoomsByDate();
                            case 8 -> roomController.roomSort();
                            case 9 -> roomController.getLastThreeGuest();
                            case 10 -> roomController.roomDetails();
                            case 11 -> exitFromSectionBool = false;
                        }
                    }
                    break;
                case 2:
                    while (exitFromSectionBool) {
                        System.out.println("\n������ ������" +
                                "\n1) ������� �����" +
                                "\n2) �������� ������ ��������� ��� �����" +
                                "\n3) ����� ����� ������" +
                                "\n4) ���������� ������" +
                                "\n5) �����");
                        sectionSwitchChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sectionSwitchChoice) {
                            case 1 -> guestController.deleteGuest();
                            case 2 -> guestController.getTotalPriceForGuest();
                            case 3 -> guestController.totalNumberOfGuests();
                            case 4 -> guestController.guestSort();
                            case 5 -> exitFromSectionBool = false;
                        }
                    }
                    break;
                case 3:
                    while (exitFromSectionBool) {
                        System.out.println("\n������ �����" +
                                "\n1) �������� ������" +
                                "\n2) �������� ���� ������" +
                                "\n3) �������� ����� ������" +
                                "\n4) ���������� �����" +
                                "\n5) ���������� ����� �����" +
                                "\n6) �����");
                        sectionSwitchChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sectionSwitchChoice) {
                            case 1 -> maintenanceController.createMaintenance();
                            case 2 -> maintenanceController.changePriceToMaintenance();
                            case 3 -> maintenanceController.addMaintenanceToGuest();
                            case 4 -> maintenanceController.maintenanceSort();
                            case 5 -> maintenanceController.maintenancesForGuestSort();
                            case 6 -> exitFromSectionBool = false;
                        }
                    }
                    break;
                case 4:
                    exitBool = false;
                    break;
            }

        }
    }
}
