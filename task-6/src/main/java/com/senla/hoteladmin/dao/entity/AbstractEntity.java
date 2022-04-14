package com.senla.hoteladmin.dao.entity;

import com.opencsv.bean.CsvBindByName;

public class AbstractEntity {
    @CsvBindByName(column = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
