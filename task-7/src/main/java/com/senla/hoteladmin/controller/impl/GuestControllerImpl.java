package com.senla.hoteladmin.controller.impl;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.util.PrettyPrinterUtil;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GuestControllerImpl implements GuestController {
    private RoomService roomService;
    private GuestService guestService;


    public GuestControllerImpl(RoomService roomService, GuestService guestService) {
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @Override
    public void deleteGuest() {
        System.out.print("Введите id номера, гостей которой надо удалить: ");
        Long id = ReaderUtil.readLong();
        guestService.deleteGuest(id);
        System.out.println("Гость/и удален/ы");
    }

    @Override
    public void getTotalPriceForGuest() {
        System.out.print("Введите id гостя: ");
        Long id = ReaderUtil.readLong();
        int total = guestService.getTotalPriceForGuest(id);
        System.out.println("Полная стоимость проживания для гостя: " + total);
    }

    @Override
    public void totalNumberOfGuests() {
        int total = guestService.totalNumberOfGuests();
        System.out.println("Общее кол-во гостей: " + total);
        getAllGuests();
    }

    @Override
    public void getGuestSortedByNameByEvicDate() {
        guestService.getGuestSortedByNameByEvicDate().forEach(System.out::println);
    }

    @Override
    public void guestSerialization() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("task-7/src/main/java/com/senla/hoteladmin/guestSave.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(guestService.getAll());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void guestDeserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("task-7/src/main/java/com/senla/hoteladmin/guestSave.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Guest> guests = (List<Guest>) objectInputStream.readObject();
        guestService.setAll(guests);
        objectInputStream.close();
        fileInputStream.close();
    }

    private void getAllGuests() {
        PrettyPrinterUtil.printFunc(guestService.getAll());
    }
}
