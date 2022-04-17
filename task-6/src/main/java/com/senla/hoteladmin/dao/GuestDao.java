package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.Guest;

public interface GuestDao extends AbstractDao<Guest> {
    void setFirstAndLastDay(Long id, int days);
}
