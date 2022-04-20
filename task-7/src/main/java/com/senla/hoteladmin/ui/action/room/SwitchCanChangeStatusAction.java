package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;

public class SwitchCanChangeStatusAction implements IAction {
    private RoomController roomController;

    public SwitchCanChangeStatusAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws IOException {
        roomController.switchCanChangeStatus();
    }
}
