package com.portflow.infra.request.container;

import com.portflow.core.domain.enums.ContainerCategory;

public record UpdateContainerRequest(
        Double tareWeight,
        Double payloadWeight,
        ContainerCategory category
) {
}
