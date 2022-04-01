package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.RoomMaxGuestsComparator;
import com.senla.hoteladmin.util.RoomPriceComparator;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStarsComparator;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    public void addToRoom(Long id, Guest guest, int days) {
        Room room = roomDao.getById(id);
        room.setGuests(guest);
        room.setStatus(RoomStatusEnum.SERVICED);
        guest.setRoom(room);
        guestDao.create(guest, IdCreatorEnum.GUEST);
        guestDao.setFirstAndLastDay(guest.getId(), days);
    }

    @Override
    public void deleteFromRoom(Long id) {
        Room room = roomDao.getById(id);
        room.setGuests(null);
        room.setStatus(RoomStatusEnum.FREE);
    }

    @Override
    public void changeStatus(Long id, RoomStatusEnum status) {
        Room room = roomDao.getById(id);
        room.setStatus(status);
    }

    @Override
    public void changePriceToRoom(Long id, int price) {
        Room room = roomDao.getById(id);
        room.setPrice(price);
    }

    @Override
    public int totalNumberOfFreeRooms() {
        int total = 0;
        for (Room room : roomDao.getAll()) {
            if (room.getStatus() == RoomStatusEnum.FREE) {
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
    public Set<Room> getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum roomSortEnum) {
        switch (roomSortEnum) {
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
            if (room.getStatus() == RoomStatusEnum.FREE) {
                roomTreeSet.add(room);
            }
        }
        return roomTreeSet;
    }

    @Override
    public String getLastThreeGuest(Long id) {
        Room room = roomDao.getById(id);
        return room.checkLastThreeGuest();
    }

    @Override
    public String roomDetails(Long id) {
        Room room = roomDao.getById(id);
        return room.toString();
    }
}
