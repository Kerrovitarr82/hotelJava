package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStatusEnum;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RoomControllerImpl implements RoomController {
    private RoomService roomService;
    private GuestService guestService;

    public RoomControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void createRoom() {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room();
        System.out.print("������� ����� �������: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();
        room.setNumber(roomNum);
        System.out.println("�������� ������ ������");
        System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
        switch (scanner.nextInt()) {
            case 1 -> room.setStatus(RoomStatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(RoomStatusEnum.SERVICED);
            case 3 -> room.setStatus(RoomStatusEnum.FREE);
        }
        System.out.print("������� ���� ������: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        room.setPrice(price);
        System.out.print("������� ������������ ���������� ������ � ������: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        room.setMaxGuests(max);
        System.out.print("������� ���������� ����� � ������: ");
        int stars = scanner.nextInt();
        scanner.nextLine();
        room.setStars(stars);
        roomService.create(room, IdCreatorEnum.ROOM);
        System.out.println("������� �������!");
    }

    @Override
    public void addToRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������, � ������� ���� �������� �����: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("������� ������ �����");
        Guest guest = new Guest();
        System.out.print("������� ���: ");
        String str = scanner.nextLine();
        guest.setName(str);
        System.out.print("������� ���������� ���� ����������: ");
        int days = scanner.nextInt();
        roomService.addToRoom(id, guest, days);
    }

    @Override
    public void deleteFromRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������, �� �������� ���� �������� ������: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������, � �������� ������ ������: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("�������� ������ ������");
        System.out.println("1) ���� ������\n2) ����� ������\n3) ���������");
        int switchChoice = scanner.nextInt();
        scanner.nextLine();
        switch (switchChoice) {
            case 1 -> roomService.changeStatus(id, RoomStatusEnum.UNDER_REPAIR);
            case 2 -> roomService.changeStatus(id, RoomStatusEnum.SERVICED);
            case 3 -> roomService.changeStatus(id, RoomStatusEnum.FREE);
        }
    }

    @Override
    public void changePriceToRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������, � �������� ������ ����: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("������� ����� ����: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("����� ���������� ��������� �������: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ���� � ������� ��.��.����: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = scanner.nextLine();
        calendar.setTime(sdf.parse(str));
        System.out.println("���� �������, ��������� ����� ������� ����: ");
        UtilityFunctions.printFunc(roomService.listOfFreeRoomsByDate(calendar));
    }

    @Override
    public void getRoomSortedByPriceByMaxGuestsByStars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������� ��� ������ �� ������ �������������");
        System.out.println("1) ��� �������\n2) ��������� �������");
        int switchChoice = scanner.nextInt();
        scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println(roomService.roomDetails(id));
    }
}
