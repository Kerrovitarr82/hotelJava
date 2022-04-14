package com.senla.hoteladmin.service;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.Main;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.dao.entity.Room;

import java.io.IOException;

public interface ExportMaintenanceCsvService extends AbstractService<Maintenance>{
    void exportCsv(String pathToCsv, Long id) throws IOException, CsvException;
}
