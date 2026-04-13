package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;
import com.portflow.core.gateway.AllocationGateway;

public class CheckInContainerUsecaseImpl implements CheckInContainerUsecase {

    private final AllocationGateway allocationGateway;

    public CheckInContainerUsecaseImpl(AllocationGateway allocationGateway) {
        this.allocationGateway = allocationGateway;
    }

    @Override
    public Allocation execute(String containerIsoCode, Long yardSlotId) {
        return allocationGateway.checkInContainer(containerIsoCode, yardSlotId);
    }
}
