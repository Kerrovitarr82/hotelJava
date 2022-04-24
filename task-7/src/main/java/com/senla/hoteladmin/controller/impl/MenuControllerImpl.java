package com.senla.hoteladmin.controller.impl;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.SerializationController;
import com.senla.hoteladmin.ui.Builder;
import com.senla.hoteladmin.ui.Navigator;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.IOException;
import java.text.ParseException;

public class MenuControllerImpl implements MenuController {
    private Builder builder;
    private Navigator navigator;
    private SerializationController serializationController;

    public MenuControllerImpl(Builder builder, Navigator navigator, SerializationController serializationController) {
        this.builder = builder;
        this.navigator = navigator;
        this.serializationController = serializationController;
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

    @Override
    public void afterStart() throws IOException, ClassNotFoundException {
        serializationController.entitiesDeserialization();
    }

    @Override
    public void beforeExit() throws IOException {
        serializationController.entitiesSerialization();
    }
}
