package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.util.GuestDateComparatorDescending;

import java.text.SimpleDateFormat;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {
    @Override
    public void update(Long id, Room entity) {
        Room room = getById(id);
        room.setNumber(entity.getNumber());
        room.setStatus(entity.getStatus());
        room.setPrice(entity.getPrice());
        room.setMaxGuests(entity.getMaxGuests());
        room.setStars(entity.getStars());
    }

    @Override
    public void setGuests(Long id, Guest guest) {
        Room room = getById(id);
        if (guest == null) {
            room.getGuests().clear();
        } else {
            room.setGuest(guest);
        }
    }

    @Override
    public String checkLastThreeGuest(Long id) {
        Room room = getById(id);
        var wrapper = new Object() {
            String threeGuests = "";
        };
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        room.getGuests().stream().sorted(new GuestDateComparatorDescending()).limit(3).forEach(guest -> {
            wrapper.threeGuests += "Имя: " + guest.getName() +
                    ". Дата заезда: " + simpleDateFormat.format(guest.getFirstDay().getTime()) +
                    ". Дата выезда: " + simpleDateFormat.format(guest.getLastDay().getTime()) + "\n";
        });
        return wrapper.threeGuests.substring(0, wrapper.threeGuests.length() - 1);
    }
}
