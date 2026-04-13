package com.portflow.core.gateway;

import com.portflow.core.domain.YardSlot;

import java.util.List;
import java.util.Map;

public interface YardSlotGateway {

    public List<YardSlot> initializeYardBlock(
            String block,
            Integer totalBays,
            Integer totalRows,
            Integer maxTiers,
            Double maxWeightCapacity);

    public YardSlot findAvailableSlot(Double containerWeight);

    public Map<String, List<YardSlot>> getYardStructure();

    public void setSlotMaintenanceStatus(Long slotId, Boolean status);

}
