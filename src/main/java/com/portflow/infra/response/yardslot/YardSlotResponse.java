package com.portflow.infra.response.yardslot;

import lombok.Builder;

@Builder
public record YardSlotResponse(
        Long id,
        String block,
        Integer bay,
        Integer row,
        Integer tier,
        Double maxWeightCapacity,
        Boolean isOperational,
        String coordinate
) {
}
