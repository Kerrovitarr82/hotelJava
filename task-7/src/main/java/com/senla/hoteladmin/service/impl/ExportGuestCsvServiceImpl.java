package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.service.ExportGuestCsvService;

import java.io.FileWriter;
import java.io.IOException;

public class ExportGuestCsvServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements ExportGuestCsvService {

    public ExportGuestCsvServiceImpl(GuestDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv) throws IOException, CsvException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv));
        StatefulBeanToCsvBuilder<Guest> builder = new StatefulBeanToCsvBuilder<>(csvWriter);
        StatefulBeanToCsv<Guest> beanWriter = builder.build();
        beanWriter.write(getAll());
        csvWriter.close();
    }
}
