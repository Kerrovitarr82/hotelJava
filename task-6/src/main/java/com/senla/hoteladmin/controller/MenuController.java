package com.senla.hoteladmin.controller;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.ParseException;

public interface MenuController extends ControllerInterface {
    void run() throws ParseException, CsvException, IOException;
}
