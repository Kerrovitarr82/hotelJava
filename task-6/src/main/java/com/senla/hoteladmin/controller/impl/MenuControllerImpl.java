package com.senla.hoteladmin.controller.impl;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.Builder;
import com.senla.hoteladmin.ui.Navigator;
import com.senla.hoteladmin.util.ReaderUtil;

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
    public void run() throws ParseException, CsvException, IOException {
        int userInput;
        builder.buildMenus();
        navigator.setCurrentMenu(builder.getRootMenu());
        while (navigator.getCurrentMenu() != null) {
            System.out.println("\nВыберите действие");
            navigator.printMenu();
            userInput = ReaderUtil.readInt();
            navigator.navigate(userInput);
        }
    }
}
