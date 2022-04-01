package com.senla.hoteladmin.controller;

import java.text.ParseException;

public interface RoomController {
    void createRoom();
    void addToRoom();
    void deleteFromRoom();
    void changeStatus();
    void changePriceToRoom();
    void totalNumberOfFreeRooms();
    void listOfFreeRoomsByDate() throws ParseException;
    void roomSort();
    void getLastThreeGuest();
    void roomDetails();
}
