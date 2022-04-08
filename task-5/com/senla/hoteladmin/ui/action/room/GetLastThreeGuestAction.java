package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

public class GetLastThreeGuestAction implements IAction {
    private RoomController roomController;

    public GetLastThreeGuestAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        roomController.getLastThreeGuest();
    }
}
