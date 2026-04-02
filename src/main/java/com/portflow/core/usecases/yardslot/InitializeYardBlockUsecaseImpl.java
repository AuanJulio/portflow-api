package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.gateway.YardSlotGateway;

import java.util.List;

public class InitializeYardBlockUsecaseImpl implements InitializeYardBlockUsecase {

    private final YardSlotGateway yardSlotGateway;

    public InitializeYardBlockUsecaseImpl(YardSlotGateway yardSlotGateway) {
        this.yardSlotGateway = yardSlotGateway;
    }

    @Override
    public List<YardSlot> execute(String block, Integer totalBays, Integer totalRows, Integer maxTiers, Double maxWeightCapacity) {
        return yardSlotGateway.initializeYardBlock(block, totalBays, totalRows, maxTiers, maxWeightCapacity);
    }
}
