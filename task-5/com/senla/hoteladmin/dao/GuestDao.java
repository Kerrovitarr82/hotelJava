package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.Guest;

public interface GuestDao extends AbstractDao<Guest> {
    int getTotalPrice(Long id);

    void countTotalPrice(Guest entity);

    void setFirstAndLastDay(Long id, int days);
}
