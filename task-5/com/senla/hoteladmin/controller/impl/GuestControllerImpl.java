package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.IdCreatorForEntities;
import com.senla.hoteladmin.util.UtilityFunctions;

import java.util.Scanner;

public class GuestControllerImpl implements GuestController {
    private RoomService roomService;
    private GuestService guestService;
    private IdCreatorForEntities idCreator;

    public GuestControllerImpl(RoomService roomService, GuestService guestService, IdCreatorForEntities idCreator) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.idCreator = idCreator;
    }

    @Override
    public void deleteGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id ������, ������ ������� ���� �������: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        guestService.deleteGuest(id);
        System.out.println("�����/� ������/�");
    }

    @Override
    public void getTotalPriceForGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� id �����: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int total = guestService.getTotalPriceForGuest(id);
        System.out.println("������ ��������� ���������� ��� �����: " + total);
    }

    @Override
    public void totalNumberOfGuests() {
        int total = guestService.totalNumberOfGuests();
        System.out.println("����� ���-�� ������: " + total);
    }

    @Override
    public void guestSort() {
        new UtilityFunctions().printFunc(guestService.guestSort());
    }
}
