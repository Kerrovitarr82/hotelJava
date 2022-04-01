package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.AbstractEntity;

import java.util.List;

public interface AbstractService <T extends AbstractEntity>{
    T getById(int id);
    List<T> getAll();
    void deleteById(int id);
    void update(int id, T entity);
    void create(T entity);
}
