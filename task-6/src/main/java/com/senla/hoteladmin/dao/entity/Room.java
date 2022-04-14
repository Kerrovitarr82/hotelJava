package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindByName;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class Room extends AbstractEntity {
    @CsvBindByName(column = "number")
    private int number;

    @CsvBindByName(column = "status")
    private RoomStatusEnum status;

    @CsvBindByName(column = "price")
    private int price;

    @CsvBindByName(column = "max guests")
    private int maxGuests;

    @CsvBindByName(column = "stars")
    private int stars;

    private List<Guest> guests = new ArrayList<>();

    public RoomStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RoomStatusEnum status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuest(Guest guest) {
        guests.add(guest);
    }

    @Override
    public String toString() {
        if (guests.size() != 0) {
            return "Room{" +
                    "id=" + getId() +
                    ", number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    ", guests=" + guests +
                    '}';
        } else {
            return "Room{" +
                    "id=" + getId() +
                    ", number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    '}';
        }
    }
}
