package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Guest extends AbstractEntity {
    @CsvBindByName(column = "name")
    private String name;

    private Room room;

    @CsvBindByName(column = "first day")
    @CsvDate("E dd.MM.yyyy")
    private Calendar firstDay;

    @CsvBindByName(column = "last day")
    @CsvDate("E dd.MM.yyyy")
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
        if (room == null) {
            return "Guest{" +
                    "id=" + getId() +
                    ", name='" + name + '\'' +
                    ", room=" + room +
                    ", maintenances=" + maintenances +
                    ", firstDay=" + simpleDateFormat.format(firstDay.getTime()) +
                    ", lastDay=" + simpleDateFormat.format(lastDay.getTime()) +
                    '}';
        } else {
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

}
