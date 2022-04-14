package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.service.ExportRoomCsvService;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportRoomCsvServiceImpl extends AbstractServiceImpl<Room, RoomDao> implements ExportRoomCsvService {

    public ExportRoomCsvServiceImpl(RoomDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv, Long id) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(pathToCsv));
        if (csvReader.peek() == null) {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv, true));
            String[] header = {"id", "number", "status", "price", "max guests", "stars"};
            csvWriter.writeNext(header);
            csvWriter.close();
        }
        Room room = getById(id);
        List<String[]> allRows = csvReader.readAll();
        csvReader.close();
        boolean existInFile = false;
        for (String[] row : allRows) {
            if (row[0].equals("id")) {
                continue;
            }
            if (Long.parseLong(row[0]) == id) {
                existInFile = true;
                row[1] = String.valueOf(room.getNumber());
                row[2] = room.getStatus().name();
                row[3] = String.valueOf(room.getPrice());
                row[4] = String.valueOf(room.getMaxGuests());
                row[5] = String.valueOf(room.getStars());
            }
        }
        if (!existInFile) {
            String[] strToCsvFile = {
                    String.valueOf(room.getId()),
                    String.valueOf(room.getNumber()),
                    room.getStatus().name(),
                    String.valueOf(room.getPrice()),
                    String.valueOf(room.getMaxGuests()),
                    String.valueOf(room.getStars())
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
