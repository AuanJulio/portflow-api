package com.portflow.core.usecases.yardslot;

public interface SetSlotMaintenanceStatusUsecase {

    public void execute(Long slotId, boolean isOperational);

}
