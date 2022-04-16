package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.entity.Room;

import java.io.IOException;

public interface ExportRoomCsvService extends AbstractService<Room> {
    void exportCsv(String pathToCsv) throws IOException, CsvException;
}
