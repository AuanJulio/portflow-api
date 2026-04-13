package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;
import com.portflow.core.gateway.AllocationGateway;

public class RelocateContainerUsecaseImpl implements RelocateContainerUsecase {

    private final AllocationGateway allocationGateway;

    public RelocateContainerUsecaseImpl(AllocationGateway allocationGateway) {
        this.allocationGateway = allocationGateway;
    }

    @Override
    public Allocation execute(String containerIsoCode, Long yardSlotId) {
        return allocationGateway.relocateContainer(containerIsoCode, yardSlotId);
    }
}
