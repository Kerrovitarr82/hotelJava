package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;

import java.util.Set;

public interface GuestService extends AbstractService<Guest>{
    void deleteGuest(int roomId);
    int getTotalPriceForGuest(int guestId);
    int totalNumberOfGuests();
    Set<Guest> guestSort();
}
