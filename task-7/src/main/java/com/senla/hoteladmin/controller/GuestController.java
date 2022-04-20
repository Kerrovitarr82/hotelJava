package com.senla.hoteladmin.controller;

import java.io.IOException;

public interface GuestController extends ControllerInterface {
    void deleteGuest();

    void getTotalPriceForGuest();

    void totalNumberOfGuests();

    void getGuestSortedByNameByEvicDate();

    void guestSerialization() throws IOException;

    void guestDeserialization() throws IOException, ClassNotFoundException;
}
