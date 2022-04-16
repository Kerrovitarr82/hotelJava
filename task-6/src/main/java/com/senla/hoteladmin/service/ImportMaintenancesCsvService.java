package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.entity.Maintenance;

import java.io.IOException;

public interface ImportMaintenancesCsvService extends AbstractService<Maintenance> {
    void importCsv(String pathToCsv) throws IOException, CsvValidationException;
}
