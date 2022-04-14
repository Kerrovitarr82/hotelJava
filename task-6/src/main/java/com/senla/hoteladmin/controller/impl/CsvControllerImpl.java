package com.senla.hoteladmin.controller.impl;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.service.ExportGuestCsvService;
import com.senla.hoteladmin.service.ExportMaintenanceCsvService;
import com.senla.hoteladmin.service.ExportRoomCsvService;
import com.senla.hoteladmin.service.ImportGuestsCsvService;
import com.senla.hoteladmin.service.ImportMaintenancesCsvService;
import com.senla.hoteladmin.service.ImportRoomsCsvService;
import com.senla.hoteladmin.util.ReaderUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CsvControllerImpl implements CsvController {
    private ExportRoomCsvService exportRoomCsvService;
    private ExportGuestCsvService exportGuestCsvService;
    private ExportMaintenanceCsvService exportMaintenanceCsvService;
    private ImportRoomsCsvService importRoomsCsvService;
    private ImportGuestsCsvService importGuestsCsvService;
    private ImportMaintenancesCsvService importMaintenancesCsvService;

    public CsvControllerImpl(ExportRoomCsvService exportRoomCsvService,
                             ExportGuestCsvService exportGuestCsvService,
                             ExportMaintenanceCsvService exportMaintenanceCsvService,
                             ImportRoomsCsvService importRoomsCsvService,
                             ImportGuestsCsvService importGuestsCsvService,
                             ImportMaintenancesCsvService importMaintenancesCsvService) {
        this.exportRoomCsvService = exportRoomCsvService;
        this.exportGuestCsvService = exportGuestCsvService;
        this.exportMaintenanceCsvService = exportMaintenanceCsvService;
        this.importRoomsCsvService = importRoomsCsvService;
        this.importGuestsCsvService = importGuestsCsvService;
        this.importMaintenancesCsvService = importMaintenancesCsvService;
    }

    @Override
    public void importRoomsCsv() throws FileNotFoundException {
        importRoomsCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/rooms.csv");
    }

    @Override
    public void importGuestsCsv() throws FileNotFoundException {
        importGuestsCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/guests.csv");
    }

    @Override
    public void importMaintenancesCsv() throws FileNotFoundException {
        importMaintenancesCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/maintenances.csv");
    }

    @Override
    public void exportRoomCsv() throws IOException, CsvException {
        System.out.println("¬ведите id");
        Long id = ReaderUtil.readLong();
        exportRoomCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/rooms.csv", id);
    }

    @Override
    public void exportGuestCsv() throws IOException, CsvException {
        System.out.println("¬ведите id");
        Long id = ReaderUtil.readLong();
        exportGuestCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/guests.csv", id);
    }

    @Override
    public void exportMaintenanceCsv() throws IOException, CsvException {
        System.out.println("¬ведите id");
        Long id = ReaderUtil.readLong();
        exportMaintenanceCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/maintenances.csv", id);
    }
}
