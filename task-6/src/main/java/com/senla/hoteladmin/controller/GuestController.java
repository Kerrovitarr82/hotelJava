package com.senla.hoteladmin.controller;

public interface GuestController extends ControllerInterface {
    void deleteGuest();

    void getTotalPriceForGuest();

    void totalNumberOfGuests();

    void getGuestSortedByNameByEvicDate();
}
