package com.senla.hoteladmin.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.ImportMaintenancesCsvService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class ImportMaintenancesCsvServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements ImportMaintenancesCsvService {

    public ImportMaintenancesCsvServiceImpl(MaintenanceDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void importCsv(String pathToCsv) throws FileNotFoundException {
        List<Maintenance> importMaintenances = new CsvToBeanBuilder<Maintenance>(new FileReader(pathToCsv)).withType(Maintenance.class).build().parse();
        for (Maintenance maintenance : importMaintenances) {
            if (getById(maintenance.getId()) != null) {
                update(maintenance.getId(), maintenance);
            } else {
                create(maintenance);
            }
        }
    }
}
