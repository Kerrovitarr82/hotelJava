package com.senla.hoteladmin.controller;

import java.io.IOException;
import java.text.ParseException;

public interface RoomController extends ControllerInterface {
    void createRoom() throws IOException;

    void addToRoom();

    void deleteFromRoom();

    void changeStatus();

    void changePriceToRoom();

    void switchCanChangeStatus() throws IOException;

    void totalNumberOfFreeRooms();

    void listOfFreeRoomsByDate() throws ParseException;

    void getAllRoomSortedByPriceByMaxGuestsByStars();

    void getFreeRoomSortedByPriceByMaxGuestsByStars();

    void getLastThreeGuest();

    void roomDetails();

    void roomHistory();

    void roomSerialization(String fileName) throws IOException;

    void roomDeserialization(String fileName) throws IOException, ClassNotFoundException;


}
