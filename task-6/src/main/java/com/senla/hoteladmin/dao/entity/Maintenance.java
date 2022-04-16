package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindByName;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Maintenance extends AbstractEntity {
    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "price")
    private int price;

    @CsvBindByName(column = "maintenance providing date")
    private Calendar maintenanceProvidingDate;

    public Maintenance() {
    }

    public Maintenance(String name, int price, Long id, Calendar maintenanceProvidingDate) {
        this.name = name;
        this.price = price;
        setId(id);
        this.maintenanceProvidingDate = maintenanceProvidingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getMaintenanceProvidingDate() {
        return maintenanceProvidingDate;
    }

    @Override
    public String toString() {
        if (maintenanceProvidingDate == null) {
            return "Maintenance{" +
                    "id=" + getId() +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy hh:mm");
            return "Maintenance{" +
                    "id=" + getId() +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", date=" + simpleDateFormat.format(maintenanceProvidingDate.getTime()) +
                    '}';
        }
    }
}
