package com.senla.hoteladmin;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.controller.impl.GuestControllerImpl;
import com.senla.hoteladmin.controller.impl.MaintenanceControllerImpl;
import com.senla.hoteladmin.controller.impl.MenuControllerImpl;
import com.senla.hoteladmin.controller.impl.RoomControllerImpl;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.impl.GuestDaoImpl;
import com.senla.hoteladmin.dao.impl.MaintenanceDaoImpl;
import com.senla.hoteladmin.dao.impl.RoomDaoImpl;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.service.impl.GuestServiceImpl;
import com.senla.hoteladmin.service.impl.MaintenanceServiceImpl;
import com.senla.hoteladmin.service.impl.RoomServiceImpl;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        RoomDao roomDao = new RoomDaoImpl();
        GuestDao guestDao = new GuestDaoImpl();
        MaintenanceDao maintenanceDao = new MaintenanceDaoImpl();
        RoomService roomService = new RoomServiceImpl(roomDao, roomDao, guestDao, maintenanceDao);
        GuestService guestService = new GuestServiceImpl(guestDao, roomDao, guestDao, maintenanceDao);
        MaintenanceService maintenanceService = new MaintenanceServiceImpl(maintenanceDao, roomDao, guestDao, maintenanceDao);
        RoomController roomController = new RoomControllerImpl(roomService, guestService);
        GuestController guestController = new GuestControllerImpl(roomService, guestService);
        MaintenanceController maintenanceController = new MaintenanceControllerImpl(roomService, guestService, maintenanceService);
        MenuController menuController = new MenuControllerImpl(roomController, guestController, maintenanceController);

        menuController.getMenu();


    }
}
