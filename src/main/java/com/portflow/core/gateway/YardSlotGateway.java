package com.portflow.core.gateway;

import com.portflow.core.domain.YardSlot;

import java.util.List;

public interface YardSlotGateway {

    public List<YardSlot> initializeYardBlock(
            String block,
            Integer totalBays,
            Integer totalRows,
            Integer maxTiers,
            Double maxWeightCapacity);

}
