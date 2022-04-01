package com.senla.hoteladmin.dao.entity;

import java.text.SimpleDateFormat;
import java.util.*;

public class Guest extends AbstractEntity{
    private String name;
    private Room room;
    private int totalPrice = 0;
    private Calendar firstDay;
    private Calendar lastDay;
    private List<Maintenance> maintenances = new ArrayList<>();

    public void setFirstAndLastDay(int days) {
        this.firstDay = new GregorianCalendar();
        this.lastDay = new GregorianCalendar();
        lastDay.add(Calendar.DAY_OF_YEAR, days);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Calendar getLastDay() {
        return lastDay;
    }

    public void setLastDay(Calendar lastDay) {
        this.lastDay = lastDay;
    }

    public Calendar getFirstDay() {
        return firstDay;
    }

    public void addMaintenances(Maintenance maintenance) {
        this.maintenances.add(maintenance);
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        return "Guest{" +
                "name='" + name + '\'' +
                ", room=" + room.getNumber() +
                ", maintenances=" + maintenances +
                ", firstDay=" + simpleDateFormat.format(firstDay.getTime()) +
                ", lastDay=" + simpleDateFormat.format(lastDay.getTime()) +
                '}';
    }

}
