package com.senla.hoteladmin.ui.action.room;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;

public class ExportRoomCsvAction implements IAction {
    private CsvController csvController;

    public ExportRoomCsvAction(CsvController csvController) {
        this.csvController = csvController;
    }

    @Override
    public void execute() throws CsvException, IOException {
        csvController.exportRoomCsv();
    }
}
