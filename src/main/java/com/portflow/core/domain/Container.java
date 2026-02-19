package com.portflow.core.domain;

import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.domain.enums.ContainerSize;

public record Container(
        Long id,
        String isoCode,
        ContainerCategory category,
        ContainerSize size,
        Double tareWeight,
        Double payloadWeight,
        String clientName
) {
}
