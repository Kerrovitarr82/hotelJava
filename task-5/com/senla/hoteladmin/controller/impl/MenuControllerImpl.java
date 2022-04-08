package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.Builder;
import com.senla.hoteladmin.ui.Navigator;
import com.senla.hoteladmin.util.ReaderUtil;

import java.text.ParseException;

public class MenuControllerImpl implements MenuController {
    private RoomController roomController;
    private GuestController guestController;
    private MaintenanceController maintenanceController;
    private Builder builder;
    private Navigator navigator;

    public MenuControllerImpl(RoomController roomController, GuestController guestController, MaintenanceController maintenanceController) {
        this.roomController = roomController;
        this.guestController = guestController;
        this.maintenanceController = maintenanceController;
        builder = new Builder(roomController, guestController, maintenanceController);
        builder.buildMenus();
        navigator = new Navigator(builder.getRootMenu());
    }

    @Override
    public void run() throws ParseException {
        int userInput;
        while (navigator.getCurrentMenu() != null) {
            System.out.println("\nВыберите действие");
            navigator.printMenu();
            userInput = ReaderUtil.readInt();
            navigator.navigate(userInput);
        }
    }
}
