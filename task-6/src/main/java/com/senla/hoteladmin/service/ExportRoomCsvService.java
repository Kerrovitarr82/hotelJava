package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.entity.Room;

import java.io.IOException;

public interface ExportRoomCsvService extends AbstractService<Room>{
    void exportCsv(String pathToCsv, Long id) throws IOException, CsvException;
}
