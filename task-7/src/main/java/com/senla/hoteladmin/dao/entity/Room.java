package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Room extends AbstractEntity implements Serializable {
    @CsvBindByName(column = "number")
    private int number;

    @CsvBindByName(column = "status")
    private RoomStatusEnum status;

    private boolean canChangeStatus = true;

    @CsvBindByName(column = "price")
    private int price;

    @CsvBindByName(column = "max guests")
    private int maxGuests;

    @CsvBindByName(column = "stars")
    private int stars;

    @CsvBindAndSplitByName(elementType = Guest.class, splitOn = "\\|", column = "guests")
    private List<Guest> guests = new ArrayList<>();

    private int maxGuestsInHistory;

    private Deque<Guest> historyOfGuests = new LinkedList<>();

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

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void setGuest(Guest guest) {
        guests.add(guest);
    }

    public boolean isCanChangeStatus() {
        return canChangeStatus;
    }

    public void setCanChangeStatus(boolean canChangeStatus) {
        this.canChangeStatus = canChangeStatus;
    }

    public int getMaxGuestsInHistory() {
        return maxGuestsInHistory;
    }

    public void setMaxGuestsInHistory(int maxGuestsInHistory) {
        this.maxGuestsInHistory = maxGuestsInHistory;
    }

    public Deque<Guest> getHistoryOfGuests() {
        return historyOfGuests;
    }

    public void setHistoryOfGuests(Deque<Guest> historyOfGuests) {
        this.historyOfGuests = historyOfGuests;
    }

    @Override
    public String toString() {
        if (guests.size() != 0) {
            return "Room{" +
                    "id=" + getId() +
                    ", number=" + number +
                    ", status=" + status +
                    ", canChangeStatus=" + canChangeStatus +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", maxGuestsInHistory=" + maxGuestsInHistory +
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
                    ", maxGuestsInHistory=" + maxGuestsInHistory +
                    ", stars=" + stars +
                    '}';
        }
    }
}
