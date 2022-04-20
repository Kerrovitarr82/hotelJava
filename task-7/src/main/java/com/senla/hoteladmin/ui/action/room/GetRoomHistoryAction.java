package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

public class GetRoomHistoryAction implements IAction {
    private RoomController roomController;

    public GetRoomHistoryAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.roomHistory();
    }
}
