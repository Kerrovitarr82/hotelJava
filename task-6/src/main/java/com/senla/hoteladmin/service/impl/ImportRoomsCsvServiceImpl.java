package com.senla.hoteladmin.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.ImportRoomsCsvService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class ImportRoomsCsvServiceImpl extends AbstractServiceImpl<Room, RoomDao> implements ImportRoomsCsvService {

    public ImportRoomsCsvServiceImpl(RoomDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void importCsv(String pathToCsv) throws FileNotFoundException {
        List<Room> importRooms = new CsvToBeanBuilder<Room>(new FileReader(pathToCsv)).withType(Room.class).build().parse();
        for (Room room : importRooms) {
            if (getById(room.getId()) != null) {
                update(room.getId(), room);
            } else {
                create(room);
            }
        }
    }
}
