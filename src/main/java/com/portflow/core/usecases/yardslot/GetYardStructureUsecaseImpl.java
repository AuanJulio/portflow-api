package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.gateway.YardSlotGateway;

import java.util.List;
import java.util.Map;

public class GetYardStructureUsecaseImpl implements GetYardStructureUsecase {

    private final YardSlotGateway yardSlotGateway;

    public GetYardStructureUsecaseImpl(YardSlotGateway yardSlotGateway) {
        this.yardSlotGateway = yardSlotGateway;
    }

    @Override
    public Map<String, List<YardSlot>> execute() {
        return yardSlotGateway.getYardStructure();
    }
}
