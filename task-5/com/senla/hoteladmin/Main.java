package com.senla.hoteladmin;

import com.senla.hoteladmin.controller.RoomController;
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


        boolean exitBool = true;
        boolean exitFromSectionBool = true;
        Scanner scanner = new Scanner(System.in);
        int mainSwitchChoice = 0;
        int sectionSwitchChoice = 0;
        while (exitBool) {
            System.out.println("Выберите действие\n");
            System.out.println("Раздел номеров" +
                    "\n1) Раздел номеров" +
                    "\n2) Раздел гостей" +
                    "\n3) Раздел услуг" +
                    "\n4) Выход");
            mainSwitchChoice = scanner.nextInt();

            switch (mainSwitchChoice) {
                case 1:
                    while (exitFromSectionBool) {
                        System.out.println("Раздел номеров" +
                                "\n1) Создать номер" +
                                "\n2) Добавить гостя в номер" +
                                "\n3) Удалить гостей из номера" +
                                "\n4) Изменить статус номера" +
                                "\n5) Изменить цену номера" +
                                "\n6) Вывести общее кол-во свободных номеров" +
                                "\n7) Вывести общее кол-во свободных номеров после определенной даты" +
                                "\n8) Вывести номера в сортированном виде" +
                                "\n9) Вывести последних трех гостей номера" +
                                "\n10) Вывести детали номера" +
                                "\n11) Выход");
                        sectionSwitchChoice = scanner.nextInt();
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
                    System.out.println("Раздел гостей" +
                            "\n1) Создать номер" +
                            "\n2) Добавить гостя в номер" +
                            "\n3) Удалить гостей из номера" +
                            "\n4) Изменить статус номера" +
                            "\n5) Изменить цену номера" +
                            "\n6) Вывести общее кол-во свободных номеров" +
                            "\n7) Вывести общее кол-во свободных номеров после определенной даты" +
                            "\n8) Вывести номера в сортированном виде" +
                            "\n9) Вывести последних трех гостей номера" +
                            "\n 10) Вывести детали номера");
                    break;
                case 3:
                    System.out.println("Раздел услуг" +
                            "\n1) Создать номер" +
                            "\n2) Добавить гостя в номер" +
                            "\n3) Удалить гостей из номера" +
                            "\n4) Изменить статус номера" +
                            "\n5) Изменить цену номера" +
                            "\n6) Вывести общее кол-во свободных номеров" +
                            "\n7) Вывести общее кол-во свободных номеров после определенной даты" +
                            "\n8) Вывести номера в сортированном виде" +
                            "\n9) Вывести последних трех гостей номера" +
                            "\n 10) Вывести детали номера");
                    break;
                case 4:
                    exitBool = false;
                    break;
            }

        }
    }
}
