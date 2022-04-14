package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.entity.Guest;

import java.io.IOException;

public interface ExportGuestCsvService extends AbstractService<Guest> {
    void exportCsv(String pathToCsv, Long id) throws IOException, CsvException;
}
