package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

public class RoomDetailsAction implements IAction {
    private RoomController roomController;

    public RoomDetailsAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.roomDetails();
    }
}
