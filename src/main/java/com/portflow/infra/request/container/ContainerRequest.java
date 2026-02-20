package com.portflow.infra.request.container;

import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.domain.enums.ContainerSize;
import lombok.Builder;

public record ContainerRequest(
        String isoCode,
        ContainerCategory category,
        ContainerSize size,
        Double tareWeight,
        Double payloadWeight,
        String clientName
) {
}
