package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.entity.Guest;

import java.io.IOException;
import java.text.ParseException;

public interface ImportGuestsCsvService extends AbstractService<Guest> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException, ParseException;
}
