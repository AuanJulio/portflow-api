package com.portflow.core.domain;

public record YardSlot(
        Long id,
        String block,
        Integer bay,
        Integer slot,
        Integer tier,
        Double maxWeightCapacity,
        Boolean isOperational
) {
}
