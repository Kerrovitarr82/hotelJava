package com.senla.hoteladmin.dao.impl;

import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.entity.Maintenance;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {
    @Override
    public void update(Long id, Maintenance entity) {
        Maintenance maintenance = getById(id);
        maintenance.setName(entity.getName());
        maintenance.setPrice(entity.getPrice());
    }
}
