package com.portflow.infra.request.allocation;

import java.time.LocalDateTime;

public record CheckInRequest(
        String containerIsoCode,
        Long yardSlotId,
        LocalDateTime estimatedDeparture
) {
}
