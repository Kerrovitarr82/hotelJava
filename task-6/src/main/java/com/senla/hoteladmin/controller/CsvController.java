package com.senla.hoteladmin.controller;

import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CsvController extends ControllerInterface {
    void importRoomsCsv() throws FileNotFoundException;

    void importGuestsCsv() throws FileNotFoundException;

    void importMaintenancesCsv() throws FileNotFoundException;

    void exportRoomCsv() throws IOException, CsvException;

    void exportGuestCsv() throws IOException, CsvException;

    void exportMaintenanceCsv() throws IOException, CsvException;
}
