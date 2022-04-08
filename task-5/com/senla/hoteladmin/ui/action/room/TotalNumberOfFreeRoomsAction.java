package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

public class TotalNumberOfFreeRoomsAction implements IAction {
    private RoomController roomController;

    public TotalNumberOfFreeRoomsAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.totalNumberOfFreeRooms();
    }
}
