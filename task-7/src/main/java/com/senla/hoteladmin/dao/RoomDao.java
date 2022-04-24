package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;

public interface RoomDao extends AbstractDao<Room> {
    void setGuests(Long id, Guest guest);

    void setGuest(Room room, Guest guest);

    String checkLastThreeGuest(Long id);
}
