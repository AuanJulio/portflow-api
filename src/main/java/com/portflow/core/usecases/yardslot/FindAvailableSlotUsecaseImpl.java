package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.gateway.YardSlotGateway;

public class FindAvailableSlotUsecaseImpl implements FindAvailableSlotUsecase {

    private final YardSlotGateway yardSlotGateway;

    public FindAvailableSlotUsecaseImpl(YardSlotGateway yardSlotGateway) {
        this.yardSlotGateway = yardSlotGateway;
    }

    @Override
    public YardSlot execute() {
        return yardSlotGateway.findAvailableSlot();
    }
}
