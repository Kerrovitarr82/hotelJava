package com.senla.hoteladmin.controller;

import java.io.IOException;

public interface GuestController extends ControllerInterface {
    void deleteGuest();

    void getTotalPriceForGuest();

    void totalNumberOfGuests();

    void getGuestSortedByNameByEvicDate();

    void guestSerialization(String fileName) throws IOException;

    void guestDeserialization(String fileName) throws IOException, ClassNotFoundException;
}
