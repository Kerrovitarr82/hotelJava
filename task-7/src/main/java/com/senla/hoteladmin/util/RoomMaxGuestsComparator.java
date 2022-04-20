package com.senla.hoteladmin.util;

import com.senla.hoteladmin.dao.entity.Room;

import java.util.Comparator;

public class RoomMaxGuestsComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getMaxGuests() >= o2.getMaxGuests()) {
            return 1;
        } else if (o1.getMaxGuests() < o2.getMaxGuests()) {
            return -1;
        } else {
            return 0;
        }
    }
}
