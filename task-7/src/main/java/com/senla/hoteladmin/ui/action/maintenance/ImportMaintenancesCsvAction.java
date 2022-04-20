package com.senla.hoteladmin.ui.action.maintenance;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;

public class ImportMaintenancesCsvAction implements IAction {
    private CsvController csvController;

    public ImportMaintenancesCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException {
        csvController.importMaintenancesCsv();
    }
}
