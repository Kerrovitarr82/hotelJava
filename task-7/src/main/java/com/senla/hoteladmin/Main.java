package com.senla.hoteladmin;

import com.opencsv.exceptions.CsvException;
import com.senla.hoteladmin.controller.CsvController;
import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.controller.MaintenanceController;
import com.senla.hoteladmin.controller.MenuController;
import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.controller.SerializationController;
import com.senla.hoteladmin.controller.impl.CsvControllerImpl;
import com.senla.hoteladmin.controller.impl.GuestControllerImpl;
import com.senla.hoteladmin.controller.impl.MaintenanceControllerImpl;
import com.senla.hoteladmin.controller.impl.MenuControllerImpl;
import com.senla.hoteladmin.controller.impl.RoomControllerImpl;
import com.senla.hoteladmin.controller.impl.SerializationControllerImpl;
import com.senla.hoteladmin.dao.GuestDao;
import com.senla.hoteladmin.dao.MaintenanceDao;
import com.senla.hoteladmin.dao.RoomDao;
import com.senla.hoteladmin.dao.impl.GuestDaoImpl;
import com.senla.hoteladmin.dao.impl.MaintenanceDaoImpl;
import com.senla.hoteladmin.dao.impl.RoomDaoImpl;
import com.senla.hoteladmin.service.ExportGuestCsvService;
import com.senla.hoteladmin.service.ExportMaintenanceCsvService;
import com.senla.hoteladmin.service.ExportRoomCsvService;
import com.senla.hoteladmin.service.GuestService;
import com.senla.hoteladmin.service.ImportGuestsCsvService;
import com.senla.hoteladmin.service.ImportMaintenancesCsvService;
import com.senla.hoteladmin.service.ImportRoomsCsvService;
import com.senla.hoteladmin.service.MaintenanceService;
import com.senla.hoteladmin.service.RoomService;
import com.senla.hoteladmin.service.impl.ExportGuestCsvServiceImpl;
import com.senla.hoteladmin.service.impl.ExportMaintenanceCsvServiceImpl;
import com.senla.hoteladmin.service.impl.ExportRoomCsvServiceImpl;
import com.senla.hoteladmin.service.impl.GuestServiceImpl;
import com.senla.hoteladmin.service.impl.ImportGuestsCsvServiceImpl;
import com.senla.hoteladmin.service.impl.ImportMaintenancesCsvServiceImpl;
import com.senla.hoteladmin.service.impl.ImportRoomsCsvServiceImpl;
import com.senla.hoteladmin.service.impl.MaintenanceServiceImpl;
import com.senla.hoteladmin.service.impl.RoomServiceImpl;
import com.senla.hoteladmin.ui.Builder;
import com.senla.hoteladmin.ui.Navigator;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, CsvException, IOException, ClassNotFoundException {
        RoomDao roomDao = new RoomDaoImpl();
        GuestDao guestDao = new GuestDaoImpl();
        MaintenanceDao maintenanceDao = new MaintenanceDaoImpl();
        RoomService roomService = new RoomServiceImpl(roomDao, roomDao, guestDao, maintenanceDao);
        GuestService guestService = new GuestServiceImpl(guestDao, roomDao, guestDao, maintenanceDao);
        MaintenanceService maintenanceService = new MaintenanceServiceImpl(maintenanceDao, roomDao, guestDao, maintenanceDao);
        ExportRoomCsvService exportRoomCsvService = new ExportRoomCsvServiceImpl(roomDao);
        ExportGuestCsvService exportGuestCsvService = new ExportGuestCsvServiceImpl(guestDao);
        ExportMaintenanceCsvService exportMaintenanceCsvService = new ExportMaintenanceCsvServiceImpl(maintenanceDao);
        ImportRoomsCsvService importRoomsCsvService = new ImportRoomsCsvServiceImpl(roomDao, guestDao, maintenanceDao);
        ImportGuestsCsvService importGuestsCsvService = new ImportGuestsCsvServiceImpl(guestDao, roomDao, maintenanceDao);
        ImportMaintenancesCsvService importMaintenancesCsvService = new ImportMaintenancesCsvServiceImpl(maintenanceDao);
        RoomController roomController = new RoomControllerImpl(roomService, guestService);
        GuestController guestController = new GuestControllerImpl(roomService, guestService);
        MaintenanceController maintenanceController = new MaintenanceControllerImpl(roomService, guestService, maintenanceService);
        CsvController csvController = new CsvControllerImpl(exportRoomCsvService, exportGuestCsvService, exportMaintenanceCsvService, importRoomsCsvService, importGuestsCsvService, importMaintenancesCsvService);
        SerializationController serializationController = new SerializationControllerImpl(roomController, guestController, maintenanceController);
        Builder builder = new Builder(roomController, guestController, maintenanceController, csvController);
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuControllerImpl(builder, navigator, serializationController);

        menuController.afterStart();
        menuController.run();
        menuController.beforeExit();
    }
}
