package com.portflow.infra.response.allocation;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.YardSlot;
import com.portflow.core.domain.enums.AllocationStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public record AllocationResponse(
        Long id,
        String containerIsoCode,
        String yardSlotCoordinate,
        LocalDateTime arrivalDate,
        LocalDateTime estimatedDeparture,
        LocalDateTime actualDeparture,
        AllocationStatus status
) {
}
