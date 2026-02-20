package com.portflow.infra.mapper;

import com.portflow.core.domain.Container;
import com.portflow.infra.persistence.ContainerEntity;
import com.portflow.infra.request.container.ContainerRequest;
import com.portflow.infra.response.container.ContainerResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContainerMapper {

    public static Container toDomain(ContainerRequest request) {
        return new Container(
                null,
                request.isoCode(),
                request.category(),
                request.size(),
                request.tareWeight(),
                request.payloadWeight(),
                request.clientName()
        );
    }

    public static ContainerResponse toResponse(Container container){
        return new ContainerResponse(
                container.id(),
                container.isoCode(),
                container.category(),
                container.size(),
                container.tareWeight(),
                container.payloadWeight(),
                container.clientName()
        );
    }

}
