package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.util.GuestAlphabetComparator;
import com.senla.hoteladmin.util.GuestDateComparator;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GuestServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements GuestService {
    private RoomDao roomDao;
    private GuestDao guestDao;
    private MaintenanceDao maintenanceDao;

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
        return guestDao.getTotalPrice(guestId);
    }

    @Override
    public int totalNumberOfGuests() {
        return guestDao.getTotalNumberOf();
    }

    @Override
    public Set<Guest> getGuestSortedByNameByEvicDate() {
        Comparator<Guest> guestComparator = new GuestAlphabetComparator().thenComparing(new GuestDateComparator());
        Set<Guest> guestTreeSet = new TreeSet<>(guestComparator);
        guestTreeSet.addAll(guestDao.getAll());
        return guestTreeSet;
    }
}
