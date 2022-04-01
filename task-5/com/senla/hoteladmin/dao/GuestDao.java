package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.Guest;

public interface GuestDao extends AbstractDao<Guest>{
    int getTotalPrice(int id);
    void countTotalPrice(Guest entity);

}
