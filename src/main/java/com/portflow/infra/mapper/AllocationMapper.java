package com.portflow.infra.mapper;

import com.portflow.infra.persistence.AllocationEntity;
import com.portflow.infra.response.allocation.AllocationResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AllocationMapper {

    public static AllocationResponse toResponse(AllocationEntity allocation){

        String isoCode = allocation.getContainer() != null
                ? allocation.getContainer().getIsoCode()
                : null;

        String coordinate = null;
        if (allocation.getYardSlot() != null) {
            coordinate = String.format("%s-%02d-%02d-%d",
                    allocation.getYardSlot().getBlock(),
                    allocation.getYardSlot().getBay(),
                    allocation.getYardSlot().getRow(),
                    allocation.getYardSlot().getTier()
            );
        }

        return AllocationResponse.builder()
                .id(allocation.getId())
                .containerIsoCode(isoCode)
                .yardSlotCoordinate(coordinate)
                .arrivalDate(allocation.getArrivalDate())
                .estimatedDeparture(allocation.getEstimatedDeparture())
                .actualDeparture(allocation.getActualDeparture())
                .status(allocation.getStatus())
                .build();

    }

}
