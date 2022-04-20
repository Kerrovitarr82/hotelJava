package com.senla.hoteladmin.ui;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.ui.action.SerializationAction;

import java.io.IOException;
import java.text.ParseException;

public class Navigator {
    private Menu currentMenu;

    public void printMenu() {
        System.out.println(currentMenu);
    }

    public void navigate(int index) throws ParseException, CsvException, IOException {
        MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
        if (menuItem.getNextMenu() == null && menuItem.getAction().getClass() == SerializationAction.class) {
            menuItem.getAction().execute();
            currentMenu = null;
        } else if (menuItem.getAction() == null) {
            currentMenu = menuItem.getNextMenu();
        } else {
            menuItem.getAction().execute();
        }
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
