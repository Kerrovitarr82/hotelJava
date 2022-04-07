package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public interface RoomService extends AbstractService<Room> {
    void addToRoom(Long id, Guest guest, int days);

    void deleteFromRoom(Long id);

    void changeStatus(Long id, RoomStatusEnum status);

    void changePriceToRoom(Long id, int price);

    int totalNumberOfFreeRooms();

    List<Room> listOfFreeRoomsByDate(Calendar date);

    Stream<Room> getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum roomSortEnum);

    String getLastThreeGuest(Long id);

    String roomDetails(Long id);

}
