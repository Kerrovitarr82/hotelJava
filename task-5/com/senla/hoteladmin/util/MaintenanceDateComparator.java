package com.senla.hoteladmin.util;

import com.senla.hoteladmin.dao.entity.Maintenance;

import java.util.Comparator;

public class MaintenanceDateComparator implements Comparator<Maintenance> {
    @Override
    public int compare(Maintenance o1, Maintenance o2) {
        if (o1.getDate().getTimeInMillis() >= o2.getDate().getTimeInMillis()) {
            return 1;
        } else if (o1.getDate().getTimeInMillis() < o2.getDate().getTimeInMillis()) {
            return -1;
        } else {
            return 0;
        }
    }
}
