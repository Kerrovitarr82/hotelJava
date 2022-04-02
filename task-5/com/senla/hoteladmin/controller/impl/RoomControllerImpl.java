package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStatusEnum;
import com.senla.hoteladmin.util.UtilReader;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RoomControllerImpl implements RoomController {
    private RoomService roomService;
    private GuestService guestService;
    private UtilReader utilReader = new UtilReader();

    public RoomControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void createRoom() {
        Room room = new Room();
        System.out.print("������� ����� �������: ");
        int roomNum = utilReader.readInt();
        room.setNumber(roomNum);
        System.out.println("�������� ������ ������");
        System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
        int switchChoice = utilReader.readInt();
        switch (switchChoice) {
            case 1 -> room.setStatus(RoomStatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(RoomStatusEnum.SERVICED);
            case 3 -> room.setStatus(RoomStatusEnum.FREE);
        }
        System.out.print("������� ���� ������: ");
        int price = utilReader.readInt();
        room.setPrice(price);
        System.out.print("������� ������������ ���������� ������ � ������: ");
        int max = utilReader.readInt();
        room.setMaxGuests(max);
        System.out.print("������� ���������� ����� � ������: ");
        int stars = utilReader.readInt();
        room.setStars(stars);
        roomService.create(room, IdCreatorEnum.ROOM);
        System.out.println("������� �������!");
    }

    @Override
    public void addToRoom() {
        System.out.print("������� id ������, � ������� ���� �������� �����: ");
        Long id = utilReader.readLong();
        System.out.println("������� ������ �����");
        Guest guest = new Guest();
        System.out.print("������� ���: ");
        String str = utilReader.readLine();
        guest.setName(str);
        System.out.print("������� ���������� ���� ����������: ");
        int days = utilReader.readInt();
        roomService.addToRoom(id, guest, days);
    }

    @Override
    public void deleteFromRoom() {
        System.out.print("������� id ������, �� �������� ���� �������� ������: ");
        Long id = utilReader.readLong();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        System.out.print("������� id ������, � �������� ������ ������: ");
        Long id = utilReader.readLong();
        System.out.println("�������� ������ ������");
        System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
        int switchChoice = utilReader.readInt();
        switch (switchChoice) {
            case 1 -> roomService.changeStatus(id, RoomStatusEnum.UNDER_REPAIR);
            case 2 -> roomService.changeStatus(id, RoomStatusEnum.SERVICED);
            case 3 -> roomService.changeStatus(id, RoomStatusEnum.FREE);
        }
    }

    @Override
    public void changePriceToRoom() {
        System.out.print("������� id ������, � �������� ������ ����: ");
        Long id = utilReader.readLong();
        System.out.print("������� ����� ����: ");
        int price = utilReader.readInt();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("����� ���������� ��������� �������: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        System.out.print("������� ���� � ������� ��.��.����: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = utilReader.readLine();
        calendar.setTime(sdf.parse(str));
        System.out.println("���� �������, ��������� ����� ������� ����: ");
        UtilityFunctions.printFunc(roomService.listOfFreeRoomsByDate(calendar));
    }

    @Override
    public void getRoomSortedByPriceByMaxGuestsByStars() {
        System.out.println("�������� ��� ������ �� ������ �������������");
        System.out.println("1) ��� �������\n2) ��������� �������");
        int switchChoice = utilReader.readInt();
        switch (switchChoice) {
            case 1 -> {
                UtilityFunctions.printFunc(roomService.getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum.ALL_ROOMS));
            }
            case 2 -> {
                UtilityFunctions.printFunc(roomService.getRoomSortedByPriceByMaxGuestsByStars(RoomSortEnum.FREE_ROOMS));
            }
        }
    }

    @Override
    public void getLastThreeGuest() {
        System.out.print("������� id ������: ");
        Long id = utilReader.readLong();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        System.out.print("������� id ������: ");
        Long id = utilReader.readLong();
        System.out.println(roomService.roomDetails(id));
    }
}
