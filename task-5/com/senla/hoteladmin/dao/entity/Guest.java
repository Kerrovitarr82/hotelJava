package com.senla.hoteladmin.dao.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Guest extends AbstractEntity {
    private String name;
    private Room room;
    private Calendar firstDay;
    private Calendar lastDay;
    private List<Maintenance> maintenances = new ArrayList<>();

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

    public void setFirstDay(Calendar firstDay) {
        this.firstDay = firstDay;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        return "Guest{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", room=" + room.getNumber() +
                ", maintenances=" + maintenances +
                ", firstDay=" + simpleDateFormat.format(firstDay.getTime()) +
                ", lastDay=" + simpleDateFormat.format(lastDay.getTime()) +
                '}';
    }

}
