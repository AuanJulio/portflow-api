package com.portflow.core.usecases.yardslot;

import com.portflow.core.gateway.YardSlotGateway;

public class SetSlotMaintenanceStatusUsecaseImpl implements SetSlotMaintenanceStatusUsecase {

    private final YardSlotGateway yardSlotGateway;

    public SetSlotMaintenanceStatusUsecaseImpl(YardSlotGateway yardSlotGateway) {
        this.yardSlotGateway = yardSlotGateway;
    }

    @Override
    public void execute(Long slotId, boolean isOperational) {
        yardSlotGateway.setSlotMaintenanceStatus(slotId, isOperational);
    }
}
