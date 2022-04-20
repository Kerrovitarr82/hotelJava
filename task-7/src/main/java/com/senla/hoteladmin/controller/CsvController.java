package com.senla.hoteladmin.controller;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.ParseException;

public interface CsvController extends ControllerInterface {
    void importRoomsCsv() throws IOException, CsvValidationException, ParseException;

    void importGuestsCsv() throws IOException, CsvValidationException, ParseException;

    void importMaintenancesCsv() throws IOException, CsvValidationException;

    void exportRoomCsv() throws IOException, CsvException;

    void exportGuestCsv() throws IOException, CsvException;

    void exportMaintenanceCsv() throws IOException, CsvException;
}
