package com.senla.hoteladmin.ui.action;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.text.ParseException;

public interface IAction {
    void execute() throws ParseException, CsvException, IOException;
}
