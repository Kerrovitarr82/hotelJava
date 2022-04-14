package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.AbstractDao;
import com.senla.hoteladmin.dao.entity.AbstractEntity;
import com.senla.hoteladmin.dao.entity.Guest;
import com.senla.hoteladmin.dao.entity.Room;
import com.senla.hoteladmin.util.IdCreatorEnum;
import com.senla.hoteladmin.util.IdCreatorForEntities;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {
    private List<T> repository = new ArrayList<>();
    private IdCreatorForEntities idCreatorForEntities = new IdCreatorForEntities();

    public T getById(Long id) {
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

    public void setAll(List<T> repository) {
        this.repository = repository;
    }

    public void deleteById(Long id) {
        T maintenance = getById(id);
        repository.remove(maintenance);
    }

    public void create(T entity) {
        if (entity.getClass() == Room.class) {
            entity.setId(idCreatorForEntities.createId(IdCreatorEnum.ROOM));
        } else if (entity.getClass() == Guest.class) {
            entity.setId(idCreatorForEntities.createId(IdCreatorEnum.GUEST));
        } else {
            entity.setId(idCreatorForEntities.createId(IdCreatorEnum.MAINTENANCE));
        }
        repository.add(entity);
    }

    @Override
    public int getTotalNumberOf() {
        return repository.size();
    }
}
