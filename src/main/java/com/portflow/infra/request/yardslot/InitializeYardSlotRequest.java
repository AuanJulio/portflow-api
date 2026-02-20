package com.portflow.infra.request.yardslot;

public record InitializeYardSlotRequest(
        String block,
        Integer totalBays,
        Integer totalRows,
        Integer maxTiers
) {
}
