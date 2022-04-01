package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {
    T getById(int id);
    List<T> getAll();
    void deleteById(int id);
    void update(int id, T entity);
    void create(T entity);
}
