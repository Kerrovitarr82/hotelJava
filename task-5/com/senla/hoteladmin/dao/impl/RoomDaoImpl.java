package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;

import java.text.SimpleDateFormat;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {
    @Override
    public void update(Long id, Room entity) {
        Room room = getById(id);
        room.setPrice(entity.getPrice());
        room.setStars(entity.getStars());
        room.setMaxGuests(entity.getMaxGuests());
    }

    @Override
    public void setGuests(Long id, Guest guest) {
        Room room = getById(id);
        if (guest == null) {
            room.getGuests().clear();
        } else {
            room.setGuest(guest);
            if (room.getLastThreeGuest().size() < 3) {
                room.setLastThreeGuest(guest);
            } else {
                room.getLastThreeGuest().poll();
                room.setLastThreeGuest(guest);
            }
        }
    }

    @Override
    public String checkLastThreeGuest(Long id) {
        Room room = getById(id);
        String threeGuests = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        for (Guest guest : room.getLastThreeGuest()) {
            threeGuests += "Имя: " + guest.getName() +
                    ". Дата заезда: " + simpleDateFormat.format(guest.getFirstDay().getTime()) +
                    ". Дата выезда: " + simpleDateFormat.format(guest.getLastDay().getTime()) + "\n";
        }
        return threeGuests.substring(0, threeGuests.length() - 1);
    }
}
