package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.AbstractDao;
import com.senla.hoteladmin.dao.entity.AbstractEntity;
import com.senla.hoteladmin.service.AbstractService;

import java.util.List;

public abstract class AbstractServiceImpl <T extends AbstractEntity, D extends AbstractDao<T>> implements AbstractService<T> {
    private D defaultDao;

    public AbstractServiceImpl(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public T getById(int id) {
        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }

    @Override
    public void deleteById(int id) {
        defaultDao.deleteById(id);
    }

    @Override
    public void update(int id, T entity) {
        defaultDao.update(id, entity);
    }

    @Override
    public void create(T entity) {
        defaultDao.create(entity);
    }
}
