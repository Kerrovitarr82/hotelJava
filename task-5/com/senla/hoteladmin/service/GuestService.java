package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;

import java.util.stream.Stream;

public interface GuestService extends AbstractService<Guest> {
    void deleteGuest(Long roomId);

    int getTotalPriceForGuest(Long guestId);

    int totalNumberOfGuests();

    Stream<Guest> getGuestSortedByNameByEvicDate();

}
