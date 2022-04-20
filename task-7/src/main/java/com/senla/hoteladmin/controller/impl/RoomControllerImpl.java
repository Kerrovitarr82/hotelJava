package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.PrettyPrinterUtil;
import com.senla.hoteladmin.util.ReaderUtil;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class RoomControllerImpl implements RoomController {
    private RoomService roomService;
    private GuestService guestService;

    public RoomControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void createRoom() throws IOException {
        Room room = new Room();
        System.out.print("������� ����� �������: ");
        int roomNum = ReaderUtil.readInt();
        room.setNumber(roomNum);
        System.out.println("�������� ������ ������");
        System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
        int switchChoice = ReaderUtil.readInt();
        switch (switchChoice) {
            case 1 -> room.setStatus(RoomStatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(RoomStatusEnum.SERVICED);
            case 3 -> room.setStatus(RoomStatusEnum.FREE);
        }
        System.out.print("������� ���� ������: ");
        int price = ReaderUtil.readInt();
        room.setPrice(price);
        System.out.print("������� ������������ ���������� ������ � ������: ");
        int max = ReaderUtil.readInt();
        room.setMaxGuests(max);
        System.out.print("������� ���������� ����� � ������: ");
        int stars = ReaderUtil.readInt();
        room.setStars(stars);
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/resources/app.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        room.setMaxGuestsInHistory(Integer.parseInt(properties.getProperty("maxGuestInHistory")));
        roomService.create(room);
        System.out.println("������� �������!");
    }

    @Override
    public void addToRoom() {
        System.out.print("������� id ������, � ������� ���� �������� �����: ");
        Long id = ReaderUtil.readLong();
        System.out.println("������� ������ �����");
        Guest guest = new Guest();
        System.out.print("������� ���: ");
        String str = ReaderUtil.readLine();
        guest.setName(str);
        System.out.print("������� ���������� ���� ����������: ");
        int days = ReaderUtil.readInt();
        roomService.addToRoom(id, guest, days);
    }

    @Override
    public void deleteFromRoom() {
        System.out.print("������� id ������, �� �������� ���� �������� ������: ");
        Long id = ReaderUtil.readLong();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        System.out.print("������� id ������, � �������� ������ ������: ");
        Long id = ReaderUtil.readLong();
        Room room = roomService.getById(id);
        if (room.isCanChangeStatus()) {
            System.out.println("�������� ������ ������");
            System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
            int switchChoice = ReaderUtil.readInt();
            switch (switchChoice) {
                case 1 -> roomService.changeStatus(room, RoomStatusEnum.UNDER_REPAIR);
                case 2 -> roomService.changeStatus(room, RoomStatusEnum.SERVICED);
                case 3 -> roomService.changeStatus(room, RoomStatusEnum.FREE);
            }
        } else {
            System.out.println("������ ������ ������ �������!");
        }
    }

    @Override
    public void changePriceToRoom() {
        System.out.print("������� id ������, � �������� ������ ����: ");
        Long id = ReaderUtil.readLong();
        System.out.print("������� ����� ����: ");
        int price = ReaderUtil.readInt();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void switchCanChangeStatus() throws IOException {
        System.out.print("������� id ������: ");
        Long id = ReaderUtil.readLong();
        Room room = roomService.getById(id);
        if (room.isCanChangeStatus()) {
            roomService.switchCanChangeStatus(room);
        } else {
            System.out.println("������ ������ ������ �������!");
        }
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("����� ���������� ��������� �������: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        System.out.print("������� ���� � ������� ��.��.����: ");
        Calendar calendar = ReaderUtil.dateReadInDdMmYyyyFormat();
        System.out.println("���� �������, ��������� ����� ������� ����: ");
        PrettyPrinterUtil.printFunc(roomService.listOfFreeRoomsByDate(calendar));
    }

    @Override
    public void getAllRoomSortedByPriceByMaxGuestsByStars() {
        roomService.getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum.ALL_ROOMS).forEach(System.out::println);
    }

    @Override
    public void getFreeRoomSortedByPriceByMaxGuestsByStars() {
        roomService.getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum.FREE_ROOMS).forEach(System.out::println);
    }

    @Override
    public void getLastThreeGuest() {
        System.out.print("������� id ������: ");
        Long id = ReaderUtil.readLong();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        System.out.print("������� id ������: ");
        Long id = ReaderUtil.readLong();
        System.out.println(roomService.roomDetails(id));
    }

    @Override
    public void roomHistory() {
        System.out.print("������� id ������: ");
        Long id = ReaderUtil.readLong();
        System.out.println(roomService.roomHistory(id));
    }

    @Override
    public void roomSerialization() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("task-7/src/main/java/com/senla/hoteladmin/roomSave.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(roomService.getAll());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void roomDeserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/java/com/senla/hoteladmin/roomSave.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Room> rooms = (List<Room>) objectInputStream.readObject();
        roomService.setAll(rooms);
        objectInputStream.close();
        fileInputStream.close();
    }
}
