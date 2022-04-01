package com.senla.hoteladmin.controller;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.util.SortAndTotalChoice;
import com.senla.hoteladmin.util.StatusEnum;

import java.text.ParseException;
import java.util.Calendar;

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
