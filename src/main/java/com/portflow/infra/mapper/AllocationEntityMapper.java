package com.portflow.infra.mapper;

import com.portflow.core.domain.Allocation;
import com.portflow.infra.persistence.AllocationEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AllocationEntityMapper {

    public static AllocationEntity toEntity(Allocation allocation){
        return new AllocationEntity(
                allocation.id(),
                ContainerEntityMapper.toEntity(allocation.container()),
                YardSlotEntityMapper.toEntity(allocation.yardSlot()),
                allocation.arrivalDate(),
                allocation.estimatedDeparture(),
                allocation.actualDeparture(),
                allocation.status()
        );
    }

    public static Allocation toDomain(AllocationEntity entity){
        return new Allocation(
                entity.getId(),
                ContainerEntityMapper.toDomain(entity.getContainer()),
                YardSlotEntityMapper.toDomain(entity.getYardSlot()),
                entity.getArrivalDate(),
                entity.getEstimatedDeparture(),
                entity.getActualDeparture(),
                entity.getStatus()
        );
    }

}
