package com.senla.hoteladmin.ui.action.guest;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;

public class ExportGuestCsvAction implements IAction {
    private CsvController csvController;

    public ExportGuestCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException {
        csvController.exportGuestCsv();
    }
}
