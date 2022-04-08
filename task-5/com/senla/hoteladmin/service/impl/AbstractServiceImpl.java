package com.senla.hoteladmin.service.impl;

import com.senla.hoteladmin.dao.AbstractDao;
import com.senla.hoteladmin.dao.entity.AbstractEntity;
import com.senla.hoteladmin.service.AbstractService;
import com.senla.hoteladmin.util.IdCreatorEnum;

import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractEntity, D extends AbstractDao<T>> implements AbstractService<T> {
    private D defaultDao;

    public AbstractServiceImpl(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public T getById(Long id) {
        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }

    @Override
    public void deleteById(Long id) {
        defaultDao.deleteById(id);
    }

    @Override
    public void update(Long id, T entity) {
        defaultDao.update(id, entity);
    }

    @Override
    public void create(T entity, IdCreatorEnum idCreatorEnum) {
        defaultDao.create(entity, idCreatorEnum);
    }
}
