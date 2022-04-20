package com.senla.hoteladmin.controller.impl;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.Builder;
import com.senla.hoteladmin.ui.Navigator;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class MenuControllerImpl implements MenuController {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;
    private Builder builder;
    private Navigator navigator;

    public MenuControllerImpl(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController, Builder builder, Navigator navigator) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
        this.builder = builder;
        this.navigator = navigator;
    }

    @Override
    public void run() throws ParseException, CsvException, IOException, ClassNotFoundException {
        int userInput;
        builder.buildMenus();
        navigator.setCurrentMenu(builder.getRootMenu());
        if (new File("task-7/src/main/java/com/senla/hoteladmin/roomSave.ser").exists()
                && new File("task-7/src/main/java/com/senla/hoteladmin/roomSave.ser").length() != 0) {
            roomController.roomDeserialization();
            System.out.println("Комнаты десериализованны!");
        }
        if (new File("task-7/src/main/java/com/senla/hoteladmin/guestSave.ser").exists()
                && new File("task-7/src/main/java/com/senla/hoteladmin/guestSave.ser").length() != 0) {
            guestController.guestDeserialization();
            System.out.println("Гости десериализованны!");
        }
        if (new File("task-7/src/main/java/com/senla/hoteladmin/maintenanceSave.ser").exists()
                && new File("task-7/src/main/java/com/senla/hoteladmin/maintenanceSave.ser").length() != 0) {
            maintenanceController.maintenanceDeserialization();
            System.out.println("Услуги десериализованны!");
        }
        while (navigator.getCurrentMenu() != null) {
            System.out.println("\nВыберите действие");
            navigator.printMenu();
            userInput = ReaderUtil.readInt();
            navigator.navigate(userInput);
        }
    }
}
