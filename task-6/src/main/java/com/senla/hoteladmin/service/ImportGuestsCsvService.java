package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.Guest;

import java.io.FileNotFoundException;

public interface ImportGuestsCsvService extends AbstractService<Guest> {
    void importCsv(String pathToCsv) throws FileNotFoundException;
}
