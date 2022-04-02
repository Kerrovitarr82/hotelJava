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
        System.out.print("Введите номер комнаты: ");
        int roomNum = utilReader.readInt();
        room.setNumber(roomNum);
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        int switchChoice = utilReader.readInt();
        switch (switchChoice) {
            case 1 -> room.setStatus(RoomStatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(RoomStatusEnum.SERVICED);
            case 3 -> room.setStatus(RoomStatusEnum.FREE);
        }
        System.out.print("Введите цену номера: ");
        int price = utilReader.readInt();
        room.setPrice(price);
        System.out.print("Введите максимальное количество гостей в номере: ");
        int max = utilReader.readInt();
        room.setMaxGuests(max);
        System.out.print("Введите количество звезд у номера: ");
        int stars = utilReader.readInt();
        room.setStars(stars);
        roomService.create(room, IdCreatorEnum.ROOM);
        System.out.println("Комната создана!");
    }

    @Override
    public void addToRoom() {
        System.out.print("Введите id номера, в который надо добавить гостя: ");
        Long id = utilReader.readLong();
        System.out.println("Введите данные гостя");
        Guest guest = new Guest();
        System.out.print("Введите имя: ");
        String str = utilReader.readLine();
        guest.setName(str);
        System.out.print("Введите количество дней проживания: ");
        int days = utilReader.readInt();
        roomService.addToRoom(id, guest, days);
    }

    @Override
    public void deleteFromRoom() {
        System.out.print("Введите id номера, из которого надо выселить гостей: ");
        Long id = utilReader.readLong();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        System.out.print("Введите id номера, у которого меняем статус: ");
        Long id = utilReader.readLong();
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        int switchChoice = utilReader.readInt();
        switch (switchChoice) {
            case 1 -> roomService.changeStatus(id, RoomStatusEnum.UNDER_REPAIR);
            case 2 -> roomService.changeStatus(id, RoomStatusEnum.SERVICED);
            case 3 -> roomService.changeStatus(id, RoomStatusEnum.FREE);
        }
    }

    @Override
    public void changePriceToRoom() {
        System.out.print("Введите id номера, у которого меняем цену: ");
        Long id = utilReader.readLong();
        System.out.print("Введите новую цену: ");
        int price = utilReader.readInt();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("Общее количество свободных номеров: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        System.out.print("Введите дату в формате дд.мм.гггг: ");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String str = utilReader.readLine();
        calendar.setTime(sdf.parse(str));
        System.out.println("Лист номеров, свободных после заданой даты: ");
        UtilityFunctions.printFunc(roomService.listOfFreeRoomsByDate(calendar));
    }

    @Override
    public void getRoomSortedByPriceByMaxGuestsByStars() {
        System.out.println("Выберите что именно вы хотите отсортировать");
        System.out.println("1) Все комнаты\n2) Свободные комнаты");
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
        System.out.print("Введите id номера: ");
        Long id = utilReader.readLong();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        System.out.print("Введите id номера: ");
        Long id = utilReader.readLong();
        System.out.println(roomService.roomDetails(id));
    }
}
