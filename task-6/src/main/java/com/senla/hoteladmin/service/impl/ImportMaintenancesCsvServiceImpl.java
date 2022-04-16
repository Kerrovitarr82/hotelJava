package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.ImportMaintenancesCsvService;

import java.io.FileReader;
import java.io.IOException;


public class ImportMaintenancesCsvServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements ImportMaintenancesCsvService {

    public ImportMaintenancesCsvServiceImpl(MaintenanceDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void importCsv(String pathToCsv) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(pathToCsv));
        Maintenance maintenance;
        while (csvReader.peek() != null) {
            String[] line = csvReader.readNext();
            if (line[0].substring(0, 1).contains("/")) {
                line = csvReader.readNext();
            }
            if (getById(Long.parseLong(line[0])) == null) {
                maintenance = maintenanceCreationAndReturn(line);
            } else {
                maintenance = getById(Long.parseLong(line[0]));
                setMaintenanceAttributes(line, maintenance);
            }
        }
    }

    private void setMaintenanceAttributes(String[] line, Maintenance maintenance) {
        maintenance.setName(line[1]);
        maintenance.setPrice(Integer.parseInt(line[2]));
    }

    private Maintenance maintenanceCreationAndReturn(String[] line) {
        Maintenance maintenance = new Maintenance();
        setMaintenanceAttributes(line, maintenance);
        create(maintenance);
        return getAll().get(getAll().size() - 1);
    }
}
