package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.PrettyPrinterUtil;
import com.senla.hoteladmin.util.ReaderUtil;

public class GuestControllerImpl implements GuestController {
    private RoomService roomService;
    private GuestService guestService;


    public GuestControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void deleteGuest() {
        System.out.print("������� id ������, ������ ������� ���� �������: ");
        Long id = ReaderUtil.readLong();
        guestService.deleteGuest(id);
        System.out.println("�����/� ������/�");
    }

    @Override
    public void getTotalPriceForGuest() {
        System.out.print("������� id �����: ");
        Long id = ReaderUtil.readLong();
        int total = guestService.getTotalPriceForGuest(id);
        System.out.println("������ ��������� ���������� ��� �����: " + total);
    }

    @Override
    public void totalNumberOfGuests() {
        int total = guestService.totalNumberOfGuests();
        System.out.println("����� ���-�� ������: " + total);
        getAllGuests();
    }

    @Override
    public void getGuestSortedByNameByEvicDate() {
        guestService.getGuestSortedByNameByEvicDate().forEach(System.out::println);
    }

    private void getAllGuests() {
        PrettyPrinterUtil.printFunc(guestService.getAll());
    }
}
