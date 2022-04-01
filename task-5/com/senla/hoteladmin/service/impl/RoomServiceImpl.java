package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;

import com.senla.hoteladmin.util.*;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.RoomService;

import java.util.*;

public class RoomServiceImpl extends AbstractServiceImpl<Room, RoomDao> implements RoomService {
    private RoomDao roomDao;
    private GuestDao guestDao;
    private MaintenanceDao maintenanceDao;

    public RoomServiceImpl(RoomDao defaultDao, RoomDao roomDao, GuestDao guestDao, MaintenanceDao maintenanceDao) {
        super(defaultDao);
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.maintenanceDao = maintenanceDao;
    }


    @Override
    public void addToRoom(int id, Guest guest) {
        Room room = roomDao.getById(id);
        room.setGuests(guest);
        room.setStatus(StatusEnum.SERVICED);
        guest.setRoom(room);
        guestDao.create(guest);
    }

    @Override
    public void deleteFromRoom(int id) {
        Room room = roomDao.getById(id);
        room.setGuests(null);
        room.setStatus(StatusEnum.FREE);
    }

    @Override
    public void changeStatus(int id, StatusEnum status) {
        Room room = roomDao.getById(id);
        room.setStatus(status);
    }

    @Override
    public void changePriceToRoom(int id, int price) {
        Room room = roomDao.getById(id);
        room.setPrice(price);
    }

    @Override
    public int totalNumberOfFreeRooms() {
        int total = 0;
        for (Room room : roomDao.getAll()) {
            if (room.getStatus() == StatusEnum.FREE) {
                total++;
            }
        }
        return total;
    }

    @Override
    public List<Room> listOfFreeRoomsByDate(Calendar date) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : roomDao.getAll()) {
            if (room.getGuests().size() == 0) {
                roomList.add(room);
            } else if (date.after(room.getGuests().get(0).getLastDay())) {
                roomList.add(room);
            }
        }
        return roomList;
    }

    @Override
    public Set<Room> roomSort(SortAndTotalChoice sortAndTotalChoice) {
        switch (sortAndTotalChoice) {
            case ALL_ROOMS -> {
                return allRoomsSort();
            }
            case FREE_ROOMS -> {
                return freeRoomsSort();
            }
        }
        return null;
    }

    private Set<Room> allRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        Set<Room> roomTreeSet = new TreeSet<>(roomComparator);
        roomTreeSet.addAll(roomDao.getAll());
        return roomTreeSet;
    }

    private Set<Room> freeRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        Set<Room> roomTreeSet = new TreeSet<>(roomComparator);
        for (Room room : roomDao.getAll()) {
            if (room.getStatus() == StatusEnum.FREE) {
                roomTreeSet.add(room);
            }
        }
        return roomTreeSet;
    }

    @Override
    public String getLastThreeGuest(int id) {
        Room room = roomDao.getById(id);
        return room.checkLastThreeGuest();
    }

    @Override
    public String roomDetails(int id) {
        Room room = roomDao.getById(id);
        return room.toString();
    }
}
