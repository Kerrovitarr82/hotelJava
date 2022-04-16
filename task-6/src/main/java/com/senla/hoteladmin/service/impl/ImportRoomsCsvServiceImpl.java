package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.ImportRoomsCsvService;
import com.senla.hoteladmin.util.DateParserUtil;
import com.senla.hoteladmin.util.RoomStatusEnum;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;


public class ImportRoomsCsvServiceImpl extends AbstractServiceImpl<Room, RoomDao> implements ImportRoomsCsvService {
    private GuestDao guestDao;
    private MaintenanceDao maintenanceDao;


    public ImportRoomsCsvServiceImpl(RoomDao defaultDao, GuestDao guestDao, MaintenanceDao maintenanceDao) {
        super(defaultDao);
        this.guestDao = guestDao;
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
                room = roomCreationAndReturn(line);
            } else {
                room = getById(Long.parseLong(line[0]));
                setRoomAttributes(line, room);
            }
            if (!line[6].equals("")) {
                if (guestDao.getById(Long.parseLong(line[6])) == null) {
                    guest = guestCreationAndReturn(line);
                    room.setGuest(guest);
                } else {
                    guest = guestDao.getById(Long.parseLong(line[6]));
                    setGuestAttributes(line, guest);
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
        room.setNumber(Integer.parseInt(line[1]));
        room.setPrice(Integer.parseInt(line[2]));
        room.setMaxGuests(Integer.parseInt(line[3]));
        room.setStars(Integer.parseInt(line[4]));
        room.setStatus(RoomStatusEnum.valueOf(line[5]));
    }

    private void setGuestAttributes(String[] line, Guest guest) throws ParseException {
        guest.setName(line[7]);
        Calendar calendar = DateParserUtil.dateParseInDdMmYyyyFormat(line[8]);
        guest.setFirstDay(calendar);
        calendar = DateParserUtil.dateParseInDdMmYyyyFormat(line[9]);
        guest.setLastDay(calendar);
    }

    private void setMaintenanceAttributes(String[] line, Maintenance maintenance) {
        maintenance.setName(line[11]);
        maintenance.setPrice(Integer.parseInt(line[12]));
    }

    private Room roomCreationAndReturn(String[] line) {
        Room room = new Room();
        setRoomAttributes(line, room);
        create(room);
        return getAll().get(getAll().size() - 1);
    }

    private Guest guestCreationAndReturn(String[] line) throws ParseException {
        Guest guest = new Guest();
        setGuestAttributes(line, guest);
        guestDao.create(guest);
        return guestDao.getAll().get(guestDao.getAll().size() - 1);
    }

    private Maintenance maintenanceCreationAndReturn(String[] line) {
        Maintenance maintenance = new Maintenance();
        setMaintenanceAttributes(line, maintenance);
        maintenanceDao.create(maintenance);
        return maintenanceDao.getAll().get(maintenanceDao.getAll().size() - 1);
    }

    private void addMaintenanceWithoutRepeats(Guest guest, Maintenance maintenance, Calendar calendar){
        for (Maintenance maintenance1 : guest.getMaintenances()) {
            if ((!maintenance1.getMaintenanceProvidingDate().getTime().equals(calendar.getTime())
                    && maintenance1.getId().equals(maintenance.getId())) || maintenance1.getId() == null) {
                guest.addMaintenances(new Maintenance(maintenance.getName(), maintenance.getPrice(), maintenance.getId(), calendar));
                break;
            }
        }
    }
}
