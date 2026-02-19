package com.portflow.core.domain;

import com.portflow.core.domain.enums.AllocationStatus;

import java.time.LocalDateTime;

public record Allocation(
        Long id,
        Container container,
        YardSlot yardSlot,
        LocalDateTime arrivalDate,
        LocalDateTime estimatedDeparture,
        LocalDateTime actualDeparture,
        AllocationStatus status
) {
}
