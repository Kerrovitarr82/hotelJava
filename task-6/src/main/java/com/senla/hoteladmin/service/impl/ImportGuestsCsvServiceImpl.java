package com.senla.hoteladmin.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.service.ImportGuestsCsvService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class ImportGuestsCsvServiceImpl extends AbstractServiceImpl<Guest, GuestDao> implements ImportGuestsCsvService {

    public ImportGuestsCsvServiceImpl(GuestDao defaultDao) {
        super(defaultDao);
    }

    @Override
    public void importCsv(String pathToCsv) throws FileNotFoundException {
        List<Guest> importGuests = new CsvToBeanBuilder<Guest>(new FileReader(pathToCsv)).withType(Guest.class).build().parse();
        for (Guest guest : importGuests) {
            if (getById(guest.getId()) != null) {
                update(guest.getId(), guest);
            } else {
                create(guest);
            }
        }
    }
}
