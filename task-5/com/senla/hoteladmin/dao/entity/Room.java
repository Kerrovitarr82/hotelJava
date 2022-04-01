package com.senla.hoteladmin.dao.entity;

import com.senla.hoteladmin.util.StatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Room extends AbstractEntity {
    private int number;
    private StatusEnum status;
    private int price;
    private int maxGuests;
    private int stars;
    private List<Guest> guests = new ArrayList<>();
    private Queue<Guest> lastThreeGuest = new LinkedList<>();

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
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

    public void setGuests(Guest guest) {
        if (guest == null) {
            this.guests.clear();
        } else {
            this.guests.add(guest);
            if (this.lastThreeGuest.size() < 3) {
                this.lastThreeGuest.add(guest);
            } else {
                this.lastThreeGuest.poll();
                this.lastThreeGuest.add(guest);
            }
        }
    }

    public String checkLastThreeGuest() {
        String threeGuests = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        for (Guest guest : lastThreeGuest) {
            threeGuests += "Имя: " + guest.getName() +
                    ". Дата заезда: " + simpleDateFormat.format(guest.getFirstDay().getTime()) +
                    ". Дата выезда: " + simpleDateFormat.format(guest.getLastDay().getTime()) + "\n";
        }
        return threeGuests.substring(0, threeGuests.length() - 1);
    }

    @Override
    public String toString() {
        if (guests.size() != 0) {
            return "Room{" +
                    "number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    ", guests=" + guests +
                    '}';
        } else {
            return "Room{" +
                    "number=" + number +
                    ", status=" + status +
                    ", price=" + price +
                    ", maxGuests=" + maxGuests +
                    ", stars=" + stars +
                    '}';
        }

    }
}
