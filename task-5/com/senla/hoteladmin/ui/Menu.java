package com.senla.hoteladmin.ui;

import java.util.ArrayList;

public class Menu {
    private String name;
    private ArrayList<MenuItem> menuItems;

    public Menu() {
        name = "";
        menuItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        String str = name + "\n";
        for (MenuItem menuItem: menuItems){
            str += menuItem.toString();
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
}
