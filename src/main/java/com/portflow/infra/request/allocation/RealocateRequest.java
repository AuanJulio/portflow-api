package com.portflow.infra.request.allocation;

public record RealocateRequest(
        String containerIsoCode,
        Long yardSlotId
) {
}
