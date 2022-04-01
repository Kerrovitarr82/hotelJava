package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.entity.Guest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {
    @Override
    public void update(Long id, Guest entity) {
        Guest guest = getById(id);
        guest.setName(entity.getName());
        guest.setRoom(entity.getRoom());
        guest.setLastDay(entity.getLastDay());
    }

    @Override
    public int getTotalPrice(Long id) {
        Guest guest = getById(id);
        countTotalPrice(guest);
        return guest.getTotalPrice();
    }

    @Override
    public void countTotalPrice(Guest entity) {
        Date date1 = new Date();
        Date date2 = entity.getLastDay().getTime();
        int total = (int) (entity.getRoom().getPrice() * ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1));
        entity.setTotalPrice(total);
    }

    @Override
    public void setFirstAndLastDay(Long id, int days) {
        Guest guest = getById(id);
        guest.setFirstDay(new GregorianCalendar());
        guest.setLastDay(new GregorianCalendar());
        guest.getLastDay().add(Calendar.DAY_OF_YEAR, days);
    }
}
