package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

import java.io.IOException;

public class CreateRoomAction implements IAction {
    private RoomController roomController;

    public CreateRoomAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws IOException {
        roomController.createRoom();
    }
}
