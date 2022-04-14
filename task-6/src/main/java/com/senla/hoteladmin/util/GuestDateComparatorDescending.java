package com.senla.hoteladmin.util;

import com.senla.hoteladmin.dao.entity.Guest;

import java.util.Comparator;

public class GuestDateComparatorDescending implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if (o1.getLastDay().compareTo(o2.getLastDay()) == 1) {
            return -1;
        } else if (o1.getLastDay().compareTo(o2.getLastDay()) == -1) {
            return 1;
        } else {
            return 0;
        }
    }
}
