package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.controller.SerializationController;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.File;
import java.io.IOException;

public class SerializationControllerImpl implements SerializationController {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;

    public SerializationControllerImpl(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
    }

    public static final String PATH_TO_SER_FILE = "task-7/src/main/java/com/senla/hoteladmin/";

    @Override
    public void entitiesSerialization() throws IOException {
        System.out.println("Введите имя файла в который надо сериализовать комнаты (с расширением)");
        String fileName = ReaderUtil.readLine();
        roomController.roomSerialization(fileName);
        System.out.println("Комнаты десериализованны!");
        System.out.println("Введите имя файла в который надо сериализовать гостей (с расширением)");
        fileName = ReaderUtil.readLine();
        guestController.guestSerialization(fileName);
        System.out.println("Гости десериализованны!");
        System.out.println("Введите имя файла в который надо сериализовать услуги (с расширением)");
        fileName = ReaderUtil.readLine();
        maintenanceController.maintenanceSerialization(fileName);
        System.out.println("Услуги десериализованны!");

    }

    @Override
    public void entitiesDeserialization() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла из которого надо десериализовать комнаты (с расширением)");
        String fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            roomController.roomDeserialization(fileName);
            System.out.println("Комнаты десериализованны!");
        }
        System.out.println("Введите имя файла из которого надо десериализовать гостей (с расширением)");
        fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            guestController.guestDeserialization(fileName);
            System.out.println("Гости десериализованны!");
        }
        System.out.println("Введите имя файла из которого надо десериализовать услуги (с расширением)");
        fileName = ReaderUtil.readLine();
        if (new File(PATH_TO_SER_FILE + fileName).exists()
                && new File(PATH_TO_SER_FILE + fileName).length() != 0) {
            maintenanceController.maintenanceDeserialization(fileName);
            System.out.println("Услуги десериализованны!");
        }
    }
}
