package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.PrettyPrinterUtil;
import com.senla.hoteladmin.util.ReaderUtil;
import com.senla.hoteladmin.util.RoomSortEnum;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.text.ParseException;
import java.util.Calendar;

public class RoomControllerImpl implements RoomController {
    private RoomService roomService;
    private GuestService guestService;

    public RoomControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void createRoom() {
        Room room = new Room();
        System.out.print("Введите номер комнаты: ");
        int roomNum = ReaderUtil.readInt();
        room.setNumber(roomNum);
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        int switchChoice = ReaderUtil.readInt();
        switch (switchChoice) {
            case 1 -> room.setStatus(RoomStatusEnum.UNDER_REPAIR);
            case 2 -> room.setStatus(RoomStatusEnum.SERVICED);
            case 3 -> room.setStatus(RoomStatusEnum.FREE);
        }
        System.out.print("Введите цену номера: ");
        int price = ReaderUtil.readInt();
        room.setPrice(price);
        System.out.print("Введите максимальное количество гостей в номере: ");
        int max = ReaderUtil.readInt();
        room.setMaxGuests(max);
        System.out.print("Введите количество звезд у номера: ");
        int stars = ReaderUtil.readInt();
        room.setStars(stars);
        roomService.create(room, IdCreatorEnum.ROOM);
        System.out.println("Комната создана!");
    }

    @Override
    public void addToRoom() {
        System.out.print("Введите id номера, в который надо добавить гостя: ");
        Long id = ReaderUtil.readLong();
        System.out.println("Введите данные гостя");
        Guest guest = new Guest();
        System.out.print("Введите имя: ");
        String str = ReaderUtil.readLine();
        guest.setName(str);
        System.out.print("Введите количество дней проживания: ");
        int days = ReaderUtil.readInt();
        roomService.addToRoom(id, guest, days);
    }

    @Override
    public void deleteFromRoom() {
        System.out.print("Введите id номера, из которого надо выселить гостей: ");
        Long id = ReaderUtil.readLong();
        roomService.deleteFromRoom(id);
    }

    @Override
    public void changeStatus() {
        System.out.print("Введите id номера, у которого меняем статус: ");
        Long id = ReaderUtil.readLong();
        System.out.println("Выберите статус номера");
        System.out.println("1) Идет ремонт\n2) Занят гостем\n3) Свободный");
        int switchChoice = ReaderUtil.readInt();
        switch (switchChoice) {
            case 1 -> roomService.changeStatus(id, RoomStatusEnum.UNDER_REPAIR);
            case 2 -> roomService.changeStatus(id, RoomStatusEnum.SERVICED);
            case 3 -> roomService.changeStatus(id, RoomStatusEnum.FREE);
        }
    }

    @Override
    public void changePriceToRoom() {
        System.out.print("Введите id номера, у которого меняем цену: ");
        Long id = ReaderUtil.readLong();
        System.out.print("Введите новую цену: ");
        int price = ReaderUtil.readInt();
        roomService.changePriceToRoom(id, price);
    }

    @Override
    public void totalNumberOfFreeRooms() {
        System.out.print("Общее количество свободных номеров: " + roomService.totalNumberOfFreeRooms());
    }

    @Override
    public void listOfFreeRoomsByDate() throws ParseException {
        System.out.print("Введите дату в формате дд.мм.гггг: ");
        Calendar calendar = ReaderUtil.dateReadInDdMmYyyyFormat();
        System.out.println("Лист номеров, свободных после заданой даты: ");
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
        System.out.print("Введите id номера: ");
        Long id = ReaderUtil.readLong();
        System.out.println(roomService.getLastThreeGuest(id));
    }

    @Override
    public void roomDetails() {
        System.out.print("Введите id номера: ");
        Long id = ReaderUtil.readLong();
        System.out.println(roomService.roomDetails(id));
    }
}
