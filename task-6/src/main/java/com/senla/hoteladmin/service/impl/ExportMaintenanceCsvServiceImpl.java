package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.ExportMaintenanceCsvService;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportMaintenanceCsvServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements ExportMaintenanceCsvService {

    public ExportMaintenanceCsvServiceImpl(MaintenanceDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv, Long id) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(pathToCsv));
        if (csvReader.peek() == null) {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv, true));
            String[] header = {"id", "name", "price"};
            csvWriter.writeNext(header);
            csvWriter.close();
        }
        Maintenance maintenance = getById(id);
        List<String[]> allRows = csvReader.readAll();
        csvReader.close();
        boolean existInFile = false;
        for (String[] row : allRows) {
            if (row[0].equals("id")) {
                continue;
            }
            if (Long.parseLong(row[0]) == id) {
                existInFile = true;
                row[1] = maintenance.getName();
                row[2] = String.valueOf(maintenance.getPrice());
            }
        }
        if (!existInFile) {
            String[] strToCsvFile = {
                    String.valueOf(maintenance.getId()),
                    maintenance.getName(),
                    String.valueOf(maintenance.getPrice())
            };
            CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv, true));
            csvWriter.writeNext(strToCsvFile);
            csvWriter.close();
        } else {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv));
            csvWriter.writeAll(allRows);
            csvWriter.close();
        }
    }
}
