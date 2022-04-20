package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.util.GuestAlphabetComparator;
import com.senla.hoteladmin.util.GuestDateComparatorAscending;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.util.Comparator;
import java.util.Date;
import java.util.stream.Stream;

public class GuestServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements GuestService {
    private RoomDao roomDao;
    private GuestDao guestDao;
    private MaintenanceDao maintenanceDao;
    private static final int MS_TO_DAYS_DIVIDER = (1000 * 60 * 60 * 24);

    public GuestServiceImpl(GuestDao defaultDao, RoomDao roomDao, GuestDao guestDao, MaintenanceDao maintenanceDao) {
        super(defaultDao);
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public void deleteGuest(Long roomId) {
        Room room = roomDao.getById(roomId);
        for (Guest guest : room.getGuests()) {
            guest.setRoom(null);
            guestDao.deleteById(guest.getId());
        }
        roomDao.setGuests(roomId, null);
        room.setStatus(RoomStatusEnum.FREE);
    }

    @Override
    public int getTotalPriceForGuest(Long guestId) {
        Guest guest = guestDao.getById(guestId);
        Date currentDate = new Date();
        Date lastDateOfGuest = guest.getLastDay().getTime();
        int total = (int) (guest.getRoom().getPrice() * ((lastDateOfGuest.getTime() - currentDate.getTime()) / MS_TO_DAYS_DIVIDER + 1));
        return total;
    }

    @Override
    public int totalNumberOfGuests() {
        return guestDao.getTotalNumberOf();
    }

    @Override
    public Stream<Guest> getGuestSortedByNameByEvicDate() {
        Comparator<Guest> guestComparator = new GuestAlphabetComparator().thenComparing(new GuestDateComparatorAscending());
        return guestDao.getAll().stream().filter(guest -> guest.getRoom() != null).sorted(guestComparator);
    }
}
