package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.util.Scanner;

public class GuestControllerImpl implements GuestController {
    private RoomService roomService;
    private GuestService guestService;

    public GuestControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void deleteGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id номера, гостей которой надо удалить: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        guestService.deleteGuest(id);
        System.out.println("Гость/и удален/ы");
    }

    @Override
    public void getTotalPriceForGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id гостя: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        int total = guestService.getTotalPriceForGuest(id);
        System.out.println("Полная стоимость проживания для гостя: " + total);
    }

    @Override
    public void totalNumberOfGuests() {
        int total = guestService.totalNumberOfGuests();
        System.out.println("Общее кол-во гостей: " + total);
    }

    @Override
    public void getGuestSortedByNameByEvicDate() {
        UtilityFunctions.printFunc(guestService.getGuestSortedByNameByEvicDate());
    }
}
