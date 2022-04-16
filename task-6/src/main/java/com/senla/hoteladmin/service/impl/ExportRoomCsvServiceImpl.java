package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.ExportRoomCsvService;

import java.io.FileWriter;
import java.io.IOException;

public class ExportRoomCsvServiceImpl extends AbstractServiceImpl<Room, RoomDao> implements ExportRoomCsvService {

    public ExportRoomCsvServiceImpl(RoomDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv) throws IOException, CsvException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv));
        StatefulBeanToCsvBuilder<Room> builder = new StatefulBeanToCsvBuilder<>(csvWriter);
        builder.withProfile("room");
        StatefulBeanToCsv<Room> beanWriter = builder.build();
        beanWriter.write(getAll());
        csvWriter.close();
    }
}
