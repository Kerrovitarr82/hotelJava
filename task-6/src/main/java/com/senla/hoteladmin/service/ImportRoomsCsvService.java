package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Room;

import java.io.FileNotFoundException;

public interface ImportRoomsCsvService extends AbstractService<Room> {
    void importCsv(String pathToCsv) throws FileNotFoundException;
}
