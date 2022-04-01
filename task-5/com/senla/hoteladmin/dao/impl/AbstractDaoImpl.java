package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.AbstractDao;
import com.senla.hoteladmin.dao.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl <T extends AbstractEntity> implements AbstractDao<T> {
    private List<T> repository = new ArrayList<>();

    public T getById(int id) {
        for (T entity : repository) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    public void deleteById(int id) {
        T maintenance = getById(id);
        repository.remove(maintenance);
    }

    public void create(T entity) {
        repository.add(entity);
    }
}
