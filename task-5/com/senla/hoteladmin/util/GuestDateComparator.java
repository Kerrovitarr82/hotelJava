package com.senla.hoteladmin.util;

import com.senla.hoteladmin.dao.entity.Guest;

import java.util.Comparator;

public class GuestDateComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if (o1.getLastDay().getTimeInMillis() >= o2.getLastDay().getTimeInMillis()) {
            return 1;
        } else if (o1.getLastDay().getTimeInMillis() < o2.getLastDay().getTimeInMillis()) {
            return -1;
        } else {
            return 0;
        }
    }
}
