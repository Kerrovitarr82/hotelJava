package com.senla.hoteladmin.ui.action.guest;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.ui.action.IAction;

public class TotalNumberOfGuestsAction implements IAction {
    private GuestController guestController;

    public TotalNumberOfGuestsAction(GuestController guestController) {
        this.guestController = guestController;
    }

    @Override
    public void execute() {
        guestController.totalNumberOfGuests();
    }
}
