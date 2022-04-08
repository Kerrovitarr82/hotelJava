package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.dao.entity.AbstractEntity;
import com.senla.hoteladmin.util.IdCreatorEnum;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {
    T getById(Long id);

    List<T> getAll();

    void deleteById(Long id);

    void update(Long id, T entity);

    void create(T entity, IdCreatorEnum idCreatorEnum);

    int getTotalNumberOf();
}
