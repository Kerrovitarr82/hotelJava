package com.senla.hoteladmin.dao.entity;

import com.senla.hoteladmin.util.RoomStatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Room extends AbstractEntity {
    private int number;
    private RoomStatusEnum status;
    private int price;
    private int maxGuests;
    private int stars;
    private List<Guest> guests = new ArrayList<>();
    private Queue<Guest> lastThreeGuest = new LinkedList<>();

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

    public Queue<Guest> getLastThreeGuest() {
        return lastThreeGuest;
    }

    public void setLastThreeGuest(Guest guest) {
        lastThreeGuest.add(guest);
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
