package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;

public interface RoomDao extends AbstractDao<Room> {
    public void setGuests(Long id, Guest guest);

    public void setGuest(Room room, Guest guest);

    public String checkLastThreeGuest(Long id);
}
