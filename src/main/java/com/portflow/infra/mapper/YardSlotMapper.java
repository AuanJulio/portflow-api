package com.portflow.infra.mapper;

import com.portflow.infra.persistence.YardSlotEntity;
import com.portflow.infra.response.yardslot.YardSlotResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class YardSlotMapper {

    public static YardSlotResponse toResponse(YardSlotEntity yardSlot){

        String coordinate = String.format("%s-%02d-%02d-%d",
                yardSlot.getBlock(),
                yardSlot.getBay(),
                yardSlot.getRow(),
                yardSlot.getTier()
                );

        return YardSlotResponse.builder()
                .id(yardSlot.getId())
                .block(yardSlot.getBlock())
                .bay(yardSlot.getBay())
                .row(yardSlot.getRow())
                .tier(yardSlot.getTier())
                .maxWeightCapacity(yardSlot.getMaxWeightCapacity())
                .isOperational(yardSlot.getIsOperational())
                .coordinate(coordinate)
                .build();

    }

}
