package com.portflow.infra.mapper;

import com.portflow.infra.persistence.ContainerEntity;
import com.portflow.infra.request.ContainerRequest;
import com.portflow.infra.response.ContainerResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContainerMapper {

    public static ContainerEntity toEntity(ContainerRequest request) {
        return ContainerEntity.builder()
                .isoCode(request.isoCode())
                .category(request.category())
                .size(request.size())
                .tareWeight(request.tareWeight())
                .payloadWeight(request.payloadWeight())
                .clientName(request.clientName())
                .build();
    }

    public static ContainerResponse toResponse(ContainerEntity container) {
        return ContainerResponse.builder()
                .id(container.getId())
                .isoCode(container.getIsoCode())
                .category(container.getCategory())
                .size(container.getSize())
                .tareWeight(container.getTareWeight())
                .payloadWeight(container.getPayloadWeight())
                .clientName(container.getClientName())
                .build();
    }

}
