package com.portflow.infra.mapper;

import com.portflow.core.domain.Container;
import com.portflow.infra.persistence.ContainerEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContainerEntityMapper {

    public static ContainerEntity toEntity(Container container) {
        return new ContainerEntity(
                container.id(),
                container.isoCode(),
                container.category(),
                container.size(),
                container.tareWeight(),
                container.payloadWeight(),
                container.clientName()
        );
    }

    public static Container toDomain(ContainerEntity entity) {
        return new Container(
                entity.getId(),
                entity.getIsoCode(),
                entity.getCategory(),
                entity.getSize(),
                entity.getTareWeight(),
                entity.getPayloadWeight(),
                entity.getClientName()
        );
    }

}
