package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.entity.Guest;

import java.util.Date;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {
    public void update(int id, Guest entity) {
        Guest guest = getById(id);
        guest.setName(entity.getName());
        guest.setRoom(entity.getRoom());
        guest.setLastDay(entity.getLastDay());
    }

    public int getTotalPrice(int id) {
        Guest guest = getById(id);
        countTotalPrice(guest);
        return guest.getTotalPrice();
    }

    public void countTotalPrice(Guest entity) {
        Date date1 = new Date();
        Date date2 = entity.getLastDay().getTime();
        int total = (int) (entity.getRoom().getPrice() * ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1));
        entity.setTotalPrice(total);
    }
}
