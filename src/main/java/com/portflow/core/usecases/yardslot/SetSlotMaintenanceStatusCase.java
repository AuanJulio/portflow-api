package com.portflow.core.usecases.yardslot;

public interface SetSlotMaintenanceStatusCase {

    public void execute(Long slotId, boolean isOperational);

}
