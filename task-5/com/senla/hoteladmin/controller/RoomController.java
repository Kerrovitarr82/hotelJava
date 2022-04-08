package com.senla.hoteladmin.controller;

import java.text.ParseException;

public interface RoomController extends ControllerInterface {
    void createRoom();

    void addToRoom();

    void deleteFromRoom();

    void changeStatus();

    void changePriceToRoom();

    void totalNumberOfFreeRooms();

    void listOfFreeRoomsByDate() throws ParseException;

    void getAllRoomSortedByPriceByMaxGuestsByStars();

    void getFreeRoomSortedByPriceByMaxGuestsByStars();

    void getLastThreeGuest();

    void roomDetails();
}
