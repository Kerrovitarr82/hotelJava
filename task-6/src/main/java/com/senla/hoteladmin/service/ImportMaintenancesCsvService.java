package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Maintenance;

import java.io.FileNotFoundException;

public interface ImportMaintenancesCsvService extends AbstractService<Maintenance> {
    void importCsv(String pathToCsv) throws FileNotFoundException;
}
