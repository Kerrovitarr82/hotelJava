package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.ImportGuestsCsvService;
import com.senla.hoteladmin.util.DateParserUtil;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;


public class ImportGuestsCsvServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements ImportGuestsCsvService {
    private RoomDao roomDao;
    private MaintenanceDao maintenanceDao;

    public ImportGuestsCsvServiceImpl(GuestDao defaultDao, RoomDao roomDao, MaintenanceDao maintenanceDao) {
        super(defaultDao);
        this.roomDao = roomDao;
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public void importCsv(String pathToCsv) throws IOException, CsvValidationException, ParseException {
        CSVReader csvReader = new CSVReader(new FileReader(pathToCsv));
        Room room;
        Guest guest;
        Maintenance maintenance;
        while (csvReader.peek() != null) {
            String[] line = csvReader.readNext();
            if (line[0].substring(0, 1).contains("/")) {
                line = csvReader.readNext();
            }
            if (getById(Long.parseLong(line[0])) == null) {
                guest = guestCreationAndReturn(line);
            } else {
                guest = getById(Long.parseLong(line[0]));
                setGuestAttributes(line, guest);
            }
            if (!line[4].equals("")) {
                if (roomDao.getById(Long.parseLong(line[4])) == null) {
                    room = roomCreationAndReturn(line);
                    room.setGuest(guest);
                } else {
                    room = roomDao.getById(Long.parseLong(line[4]));
                    setRoomAttributes(line, room);
                    guest.setRoom(room);
                }
                if (!line[10].equals("")) {
                    if (maintenanceDao.getById(Long.parseLong(line[10])) == null) {
                        maintenance = maintenanceCreationAndReturn(line);
                    } else {
                        maintenance = maintenanceDao.getById(Long.parseLong(line[10]));
                        setMaintenanceAttributes(line, maintenance);
                    }
                    Calendar calendar = DateParserUtil.dateParseInDdMmYyyyFormat(line[13]);
                    if (guest.getMaintenances().size() != 0) {
                        addMaintenanceWithoutRepeats(guest, maintenance, calendar);
                    } else {
                        guest.addMaintenances(new Maintenance(maintenance.getName(), maintenance.getPrice(), maintenance.getId(), calendar));
                    }
                }
            }
        }
    }

    private void setRoomAttributes(String[] line, Room room) {
        room.setNumber(Integer.parseInt(line[5]));
        room.setPrice(Integer.parseInt(line[6]));
        room.setStatus(RoomStatusEnum.valueOf(line[7]));
        room.setMaxGuests(Integer.parseInt(line[8]));
        room.setStars(Integer.parseInt(line[9]));
    }

    private void setGuestAttributes(String[] line, Guest guest) throws ParseException {
        guest.setName(line[1]);
        Calendar calendar = DateParserUtil.dateParseInDdMmYyyyFormat(line[2]);
        guest.setFirstDay(calendar);
        calendar = DateParserUtil.dateParseInDdMmYyyyFormat(line[3]);
        guest.setLastDay(calendar);
    }

    private void setMaintenanceAttributes(String[] line, Maintenance maintenance) {
        maintenance.setName(line[11]);
        maintenance.setPrice(Integer.parseInt(line[12]));
    }

    private Room roomCreationAndReturn(String[] line) {
        Room room = new Room();
        setRoomAttributes(line, room);
        roomDao.create(room);
        return roomDao.getAll().get(roomDao.getAll().size() - 1);
    }

    private Guest guestCreationAndReturn(String[] line) throws ParseException {
        Guest guest = new Guest();
        setGuestAttributes(line, guest);
        create(guest);
        return getAll().get(getAll().size() - 1);
    }

    private Maintenance maintenanceCreationAndReturn(String[] line) {
        Maintenance maintenance = new Maintenance();
        setMaintenanceAttributes(line, maintenance);
        maintenanceDao.create(maintenance);
        return maintenanceDao.getAll().get(maintenanceDao.getAll().size() - 1);
    }

    private void addMaintenanceWithoutRepeats(Guest guest, Maintenance maintenance, Calendar calendar) {
        for (Maintenance maintenance1 : guest.getMaintenances()) {
            if ((!maintenance1.getMaintenanceProvidingDate().getTime().equals(calendar.getTime())
                    && maintenance1.getId().equals(maintenance.getId())) || maintenance1.getId() == null) {
                guest.addMaintenances(new Maintenance(maintenance.getName(), maintenance.getPrice(), maintenance.getId(), calendar));
                break;
            }
        }
    }
}
