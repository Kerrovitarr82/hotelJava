package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.util.SortAndTotalChoice;
import com.senla.hoteladmin.util.StatusEnum;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface RoomService extends AbstractService<Room>{
    void addToRoom(int id, Guest guest);
    void deleteFromRoom(int id);
    void changeStatus(int id, StatusEnum status);
    void changePriceToRoom(int id, int price);
    int totalNumberOfFreeRooms();
    List<Room> listOfFreeRoomsByDate(Calendar date);
    Set<Room> roomSort(SortAndTotalChoice sortAndTotalChoice);
    String getLastThreeGuest(int id);
    String roomDetails(int id);

}
