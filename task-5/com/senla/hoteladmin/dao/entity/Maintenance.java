package com.senla.hoteladmin.dao.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Maintenance extends AbstractEntity{
    private String name;
    private int price;
    private Calendar date;

    public Maintenance(){}

    public Maintenance(String name, int price, int id, Calendar date) {
        this.name = name;
        this.price = price;
        setId(id);
        this.date = date;
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

    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        if (date == null) {
            return "Maintenance{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", id=" + getId() +
                    '}';
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy hh:mm");
            return "Maintenance{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", id=" + getId() +
                    ", date=" + simpleDateFormat.format(date.getTime()) +
                    '}';
        }
    }
}
