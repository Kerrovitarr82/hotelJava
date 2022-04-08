package com.senla.hoteladmin.ui;

import java.text.ParseException;

public class Navigator {
    private Menu currentMenu;

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        System.out.println(currentMenu);
    }

    public void navigate(int index) throws ParseException {
        MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
        if (menuItem.getAction() == null) {
             if (menuItem.getNextMenu() != null) {
                 currentMenu = menuItem.getNextMenu();
             } else {
                 currentMenu = null;
             }
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
