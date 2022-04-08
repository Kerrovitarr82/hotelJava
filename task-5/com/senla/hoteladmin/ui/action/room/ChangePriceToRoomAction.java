package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

public class ChangePriceToRoomAction implements IAction {
    private RoomController roomController;

    public ChangePriceToRoomAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.changePriceToRoom();
    }
}
