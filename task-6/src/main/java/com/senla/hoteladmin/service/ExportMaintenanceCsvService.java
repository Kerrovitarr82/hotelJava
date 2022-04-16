package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.entity.Maintenance;

import java.io.IOException;

public interface ExportMaintenanceCsvService extends AbstractService<Maintenance> {
    void exportCsv(String pathToCsv) throws IOException, CsvException;
}
