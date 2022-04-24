package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.RoomMaxGuestsComparator;
import com.senla.hoteladmin.util.RoomPriceComparator;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStarsComparator;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

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
        roomDao.setGuests(id, guest);
        room.setStatus(RoomStatusEnum.SERVICED);
        guest.setRoom(room);
        guestDao.create(guest);
        guestDao.setFirstAndLastDay(guest.getId(), days);
    }

    @Override
    public void deleteFromRoom(Long id) {
        Room room = roomDao.getById(id);
        roomDao.setGuests(id, null);
        room.setStatus(RoomStatusEnum.FREE);
    }

    @Override
    public void changeStatus(Room room, RoomStatusEnum status) {
        room.setStatus(status);
    }

    @Override
    public void changePriceToRoom(Long id, int price) {
        Room room = roomDao.getById(id);
        room.setPrice(price);
    }

    @Override
    public void switchCanChangeStatus(Room room) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/resources/app.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if (room.isCanChangeStatus()) {
            room.setCanChangeStatus(Boolean.parseBoolean(properties.getProperty("canChangeStatus.false")));
        } else {
            room.setCanChangeStatus(Boolean.parseBoolean(properties.getProperty("canChangeStatus.true")));
        }
        System.out.println("Room canChangeStatus is: " + room.isCanChangeStatus());
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
    public Stream<Room> getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum roomSortEnum) {
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

    @Override
    public String getLastThreeGuest(Long id) {
        return roomDao.checkLastThreeGuest(id);
    }

    @Override
    public String roomDetails(Long id) {
        Room room = roomDao.getById(id);
        return room.toString();
    }

    @Override
    public String roomHistory(Long id) {
        Room room = roomDao.getById(id);
        return room.getHistoryOfGuests().toString();
    }

    @Override
    public void roomSerialization(String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("task-7/src/main/java/com/senla/hoteladmin/" + fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(roomDao.getAll());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void roomDeserialization(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/java/com/senla/hoteladmin/" + fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Room> rooms = (List<Room>) objectInputStream.readObject();
        roomDao.setAll(rooms);
        objectInputStream.close();
        fileInputStream.close();
    }

    private Stream<Room> allRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        return roomDao.getAll().stream().sorted(roomComparator);
    }

    private Stream<Room> freeRoomsSort() {
        Comparator<Room> roomComparator = new RoomPriceComparator().thenComparing(new RoomMaxGuestsComparator()).thenComparing(new RoomStarsComparator());
        return roomDao.getAll().stream().filter(room -> room.getStatus() == RoomStatusEnum.FREE).sorted(roomComparator);
    }

}
