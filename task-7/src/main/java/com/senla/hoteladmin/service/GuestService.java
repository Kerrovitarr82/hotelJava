package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;

import java.io.IOException;
import java.util.stream.Stream;

public interface GuestService extends AbstractService<Guest> {
    void deleteGuest(Long roomId);

    int getTotalPriceForGuest(Long guestId);

    int totalNumberOfGuests();

    Stream<Guest> getGuestSortedByNameByEvicDate();

    void guestSerialization(String fileName) throws IOException;

    void guestDeserialization(String fileName) throws IOException, ClassNotFoundException;
}
