package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByNames;

public class AbstractEntity {
    @CsvBindByName(column = "room Id", profiles = "room")
    @CsvBindByName(column = "guest Id", profiles = "guest")
    @CsvBindByName(column = "maintenance Id", profiles = "maintenance")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
