package com.senla.hoteladmin.controller;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.text.ParseException;

public interface MenuController extends ControllerInterface {
    void run() throws ParseException, CsvException, IOException, ClassNotFoundException;

    void afterStart() throws IOException, ClassNotFoundException;

    void beforeExit() throws IOException;
}
