package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.entity.AbstractEntity;

import java.util.List;

public interface AbstractService<T extends AbstractEntity> {
    T getById(Long id);

    List<T> getAll();

    void setAll(List<T> repository);

    void deleteById(Long id);

    void update(Long id, T entity);

    void create(T entity);
}
