package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.entity.Room;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface ImportRoomsCsvService extends AbstractService<Room> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException, ParseException;
}
