package com.portflow.infra.response;

import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.domain.enums.ContainerSize;
import lombok.Builder;

@Builder
public record ContainerResponse(
        Long id,
        String isoCode,
        ContainerCategory category,
        ContainerSize size,
        Double tareWeight,
        Double payloadWeight,
        String clientName
) {
}
