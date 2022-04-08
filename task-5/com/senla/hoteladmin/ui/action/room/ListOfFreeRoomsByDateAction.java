package com.senla.hoteladmin.ui.action.room;

import com.senla.hoteladmin.controller.RoomController;
import com.senla.hoteladmin.ui.action.IAction;

import java.text.ParseException;

public class ListOfFreeRoomsByDateAction implements IAction {
    private RoomController roomController;

    public ListOfFreeRoomsByDateAction(RoomController roomController) {
        this.roomController = roomController;
    }

    @Override
    public void execute() throws ParseException {
        roomController.listOfFreeRoomsByDate();
    }
}
