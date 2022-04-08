package com.senla.hoteladmin.ui.action.guest;

import com.senla.hoteladmin.controller.GuestController;
import com.senla.hoteladmin.ui.action.IAction;

public class GetGuestSortedByNameByEvicDateAction implements IAction {
    private GuestController guestController;

    public GetGuestSortedByNameByEvicDateAction(GuestController guestController) {
        this.guestController = guestController;
    }

    @Override
    public void execute() {
        guestController.getGuestSortedByNameByEvicDate();
    }
}
