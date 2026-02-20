package com.portflow.infra.mapper;

import com.portflow.core.domain.YardSlot;
import com.portflow.infra.persistence.YardSlotEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class YardSlotEntityMapper {

    public static YardSlotEntity toEntity(YardSlot yardSlot){
        return new YardSlotEntity(
                yardSlot.id(),
                yardSlot.block(),
                yardSlot.bay(),
                yardSlot.row(),
                yardSlot.tier(),
                yardSlot.maxWeightCapacity(),
                yardSlot.isOperational()
        );
    }

    public static YardSlot toDomain(YardSlotEntity entity){
        return new YardSlot(
                entity.getId(),
                entity.getBlock(),
                entity.getBay(),
                entity.getRow(),
                entity.getTier(),
                entity.getMaxWeightCapacity(),
                entity.getIsOperational()
        );
    }

}
