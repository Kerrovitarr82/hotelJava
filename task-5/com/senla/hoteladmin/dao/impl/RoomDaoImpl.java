package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Room;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {
    @Override
    public void update(Long id, Room entity) {
        Room room = getById(id);
        room.setPrice(entity.getPrice());
        room.setStars(entity.getStars());
        room.setMaxGuests(entity.getMaxGuests());
    }
}
