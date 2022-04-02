package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.util.UtilReader;

import java.text.ParseException;

public class MenuControllerImpl implements MenuController {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;
    private UtilReader utilReader = new UtilReader();

    public MenuControllerImpl(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
    }

    @Override
    public void getMenu() throws ParseException {
        boolean exitBool = true;
        boolean exitFromSectionBool;
        int mainSwitchChoice = 0;
        int sectionSwitchChoice = 0;
        while (exitBool) {
            System.out.println("\n�������� ��������");
            System.out.println("\n�������" +
                    "\n1) ������ �������" +
                    "\n2) ������ ������" +
                    "\n3) ������ �����" +
                    "\n4) �����");
            mainSwitchChoice = utilReader.readInt();
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
                        sectionSwitchChoice = utilReader.readInt();
                        switch (sectionSwitchChoice) {
                            case 1 -> roomController.createRoom();
                            case 2 -> roomController.addToRoom();
                            case 3 -> roomController.deleteFromRoom();
                            case 4 -> roomController.changeStatus();
                            case 5 -> roomController.changePriceToRoom();
                            case 6 -> roomController.totalNumberOfFreeRooms();
                            case 7 -> roomController.listOfFreeRoomsByDate();
                            case 8 -> roomController.getRoomSortedByPriceByMaxGuestsByStars();
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
                        sectionSwitchChoice = utilReader.readInt();
                        switch (sectionSwitchChoice) {
                            case 1 -> guestController.deleteGuest();
                            case 2 -> guestController.getTotalPriceForGuest();
                            case 3 -> guestController.totalNumberOfGuests();
                            case 4 -> guestController.getGuestSortedByNameByEvicDate();
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
                        sectionSwitchChoice = utilReader.readInt();
                        switch (sectionSwitchChoice) {
                            case 1 -> maintenanceController.createMaintenance();
                            case 2 -> maintenanceController.changePriceToMaintenance();
                            case 3 -> maintenanceController.addMaintenanceToGuest();
                            case 4 -> maintenanceController.getMaintenanceSortedByPrice();
                            case 5 -> maintenanceController.getMaintenancesForGuestSortedByPriceByDate();
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
