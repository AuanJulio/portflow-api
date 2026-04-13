package com.portflow.core.usecases.allocation;

import com.portflow.core.gateway.AllocationGateway;

public class CheckOutContainerUsecaseImpl implements CheckOutContainerUsecase {

    private final AllocationGateway allocationGateway;

    public CheckOutContainerUsecaseImpl(AllocationGateway allocationGateway) {
        this.allocationGateway = allocationGateway;
    }

    @Override
    public void execute(String containerIsoCode) {
        allocationGateway.checkOutContainer(containerIsoCode);
    }
}
