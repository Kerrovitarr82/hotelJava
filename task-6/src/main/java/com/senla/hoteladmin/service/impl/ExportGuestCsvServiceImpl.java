package com.senla.hoteladmin.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.service.ExportGuestCsvService;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExportGuestCsvServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements ExportGuestCsvService {

    public ExportGuestCsvServiceImpl(GuestDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void exportCsv(String pathToCsv, Long id) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(pathToCsv));
        if (csvReader.peek() == null) {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(pathToCsv, true));
            String[] header = {"id", "name", "first day", "last day"};
            csvWriter.writeNext(header);
            csvWriter.close();
        }
        Guest guest = getById(id);
        List<String[]> allRows = csvReader.readAll();
        csvReader.close();
        boolean existInFile = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd.MM.yyyy");
        for (String[] row : allRows) {
            if (row[0].equals("id")) {
                continue;
            }
            if (Long.parseLong(row[0]) == id) {
                existInFile = true;
                row[1] = guest.getName();
                row[2] = simpleDateFormat.format(guest.getFirstDay().getTime());
                row[3] = simpleDateFormat.format(guest.getLastDay().getTime());
            }
        }
        if (!existInFile) {
            String[] strToCsvFile = {
                    String.valueOf(guest.getId()),
                    guest.getName(),
                    simpleDateFormat.format(guest.getFirstDay().getTime()),
                    simpleDateFormat.format(guest.getLastDay().getTime())
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
