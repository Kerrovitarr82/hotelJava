package com.senla.hoteladmin.ui.action.guest;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;
import java.text.ParseException;

public class ImportGuestsCsvAction implements IAction {
    private CsvController csvController;

    public ImportGuestsCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException, ParseException {
        csvController.importGuestsCsv();
    }
}
