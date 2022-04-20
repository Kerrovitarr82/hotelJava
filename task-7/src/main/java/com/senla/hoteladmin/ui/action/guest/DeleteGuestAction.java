package com.senla.hoteladmin.ui.action.guest;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.ui.action.IAction;

public class DeleteGuestAction implements IAction {
    private GuestController guestController;

    public DeleteGuestAction(GuestController guestController) {
        this.guestController = guestController;
    }

    @Override
    public void execute() {
        guestController.deleteGuest();
    }
}
