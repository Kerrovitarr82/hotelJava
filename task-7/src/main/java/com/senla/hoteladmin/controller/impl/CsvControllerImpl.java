package com.senla.hoteladmin.controller.impl;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.service.ExportGuestCsvService;
import com.senla.hoteladmin.service.ExportMaintenanceCsvService;
import com.senla.hoteladmin.service.ExportRoomCsvService;
import com.senla.hoteladmin.service.ImportGuestsCsvService;
import com.senla.hoteladmin.service.ImportMaintenancesCsvService;
import com.senla.hoteladmin.service.ImportRoomsCsvService;

import java.io.IOException;
import java.text.ParseException;

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
    public void importRoomsCsv() throws IOException, CsvValidationException, ParseException {
        importRoomsCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/roomsImport.csv");
    }

    @Override
    public void importGuestsCsv() throws IOException, CsvValidationException, ParseException {
        importGuestsCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/guestsImport.csv");
    }

    @Override
    public void importMaintenancesCsv() throws IOException, CsvValidationException {
        importMaintenancesCsvService.importCsv("task-6/src/main/java/com/senla/hoteladmin/maintenancesImport.csv");
    }

    @Override
    public void exportRoomCsv() throws IOException, CsvException {
        exportRoomCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/roomsExport.csv");
    }

    @Override
    public void exportGuestCsv() throws IOException, CsvException {
        exportGuestCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/guestsExport.csv");
    }

    @Override
    public void exportMaintenanceCsv() throws IOException, CsvException {
        exportMaintenanceCsvService.exportCsv("task-6/src/main/java/com/senla/hoteladmin/maintenancesExport.csv");
    }
}
