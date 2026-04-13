package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;
import com.portflow.core.gateway.AllocationGateway;

import java.util.List;

public class GetContainerHistoryUsecaseImpl implements GetContainerHistoryUsecase {

    private final AllocationGateway allocationGateway;

    public GetContainerHistoryUsecaseImpl(AllocationGateway allocationGateway) {
        this.allocationGateway = allocationGateway;
    }

    @Override
    public List<Allocation> execute(String containerIsoCode) {
        return allocationGateway.getContainerHistory(containerIsoCode);
    }
}
