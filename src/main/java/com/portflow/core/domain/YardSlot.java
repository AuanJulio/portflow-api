package com.portflow.core.domain;

public record YardSlot(
        Long id,
        String block,
        Integer bay,
        Integer row,
        Integer tier,
        Double maxWeightCapacity,
        Boolean isOperational
) {
}
