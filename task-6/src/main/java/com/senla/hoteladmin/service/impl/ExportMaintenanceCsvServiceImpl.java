package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.entity.Maintenance;
import com.senla.hoteladmin.service.ExportMaintenanceCsvService;

import java.io.FileWriter;
import java.io.IOException;

public class ExportMaintenanceCsvServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements ExportMaintenanceCsvService {

    public ExportMaintenanceCsvServiceImpl(MaintenanceDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv) throws IOException, CsvException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv));
        StatefulBeanToCsvBuilder<Maintenance> builder = new StatefulBeanToCsvBuilder<>(csvWriter);
        StatefulBeanToCsv<Maintenance> beanWriter = builder.build();
        beanWriter.write(getAll());
        csvWriter.close();
    }
}
