package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.IdCreatorForEntities;
import com.senla.hoteladmin.util.SortAndTotalChoice;
import com.senla.hoteladmin.util.StatusEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RoomControllerImpl implements RoomController {
    private RoomService roomService;
    private GuestService guestService;
    private IdCreatorForEntities idCreator;

    public RoomControllerImpl(RoomService roomService, GuestService guestService, IdCreatorForEntities idCreator) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.idCreator = idCreator;
    }

    @Override
    public void createRoom() {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room();
        room.setId(idCreator.createId(IdCreatorEnum.ROOM));
        System.out.print("Введите номер комнаты: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();
        room.setNumber(roomNum);
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        switch (scanner.nextInt()) {
            case 1 -> room.setStatus(StatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(StatusEnum.SERVICED);
            case 3 -> room.setStatus(StatusEnum.FREE);
        }
        System.out.print("Введите цену номера: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        room.setPrice(price);
        System.out.print("Введите максимальное количество гостей в номере: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        room.setMaxGuests(max);
        System.out.print("Введите количество звезд у номера: ");
        int stars = scanner.nextInt();
        scanner.nextLine();
        room.setStars(stars);
        roomService.create(room);
        System.out.println("Комната создана!");
    }

    @Override
    public void addToRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера, в который надо добавить гостя: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите данные гостя");
        Guest guest = new Guest();
        guest.setId(idCreator.createId(IdCreatorEnum.GUEST));
        System.out.print("Введите имя: ");
        String str = scanner.nextLine();
        guest.setName(str);
        System.out.print("Введите количество дней проживания: ");
        int days = scanner.nextInt();
        guest.setFirstAndLastDay(days);
        roomService.addToRoom(id, guest);
    }

    @Override
    public void deleteFromRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера, из которого надо выселить гостей: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера, у которого меняем статус: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        int switchChoice = scanner.nextInt();
        scanner.nextLine();
        switch (switchChoice) {
            case 1 -> roomService.changeStatus(id, StatusEnum.UNDER_REPAIR);
            case 2 -> roomService.changeStatus(id, StatusEnum.SERVICED);
            case 3 -> roomService.changeStatus(id, StatusEnum.FREE);
        }
    }

    @Override
    public void changePriceToRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера, у которого меняем цену: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите новую цену: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("Общее количество свободных номеров: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате дд.мм.гггг: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = scanner.nextLine();
        calendar.setTime(sdf.parse(str));
        System.out.println("Лист номеров, свободных после заданой даты: ");
        System.out.println(roomService.listOfFreeRoomsByDate(calendar));
    }

    @Override
    public void roomSort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите что именно вы хотите отсортировать");
        System.out.println("1) Все комнаты\n2) Свободные комнаты");
        int switchChoice = scanner.nextInt();
        scanner.nextLine();
        switch (switchChoice) {
            case 1 -> {
                for (Room room : roomService.roomSort(SortAndTotalChoice.ALL_ROOMS)) {
                    System.out.println(room);
                }
            }
            case 2 -> {
                for (Room room : roomService.roomSort(SortAndTotalChoice.FREE_ROOMS)) {
                    System.out.println(room);
                }
            }
        }
    }

    @Override
    public void getLastThreeGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(roomService.roomDetails(id));
    }
}
