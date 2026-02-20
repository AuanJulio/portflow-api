package com.portflow.infra.mapper;

import com.portflow.core.domain.YardSlot;
import com.portflow.infra.response.yardslot.YardSlotResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class YardSlotMapper {

    public static YardSlotResponse toResponse(YardSlot yardSlot){

        String coordinate = String.format("%s-%02d-%02d-%d",
                yardSlot.block(),
                yardSlot.bay(),
                yardSlot.row(),
                yardSlot.tier()
                );

        return new YardSlotResponse(
                yardSlot.id(),
                yardSlot.block(),
                yardSlot.bay(),
                yardSlot.row(),
                yardSlot.tier(),
                yardSlot.maxWeightCapacity(),
                yardSlot.isOperational(),
                coordinate
        );

    }

}
