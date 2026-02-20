package com.portflow.infra.mapper;

import com.portflow.core.domain.Allocation;
import com.portflow.infra.persistence.AllocationEntity;
import com.portflow.infra.response.allocation.AllocationResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AllocationMapper {

    public static AllocationResponse toResponse(Allocation allocation){

        String isoCode = allocation.container() != null
                ? allocation.container().isoCode()
                : null;

        String coordinate = null;
        if (allocation.yardSlot() != null) {
            coordinate = String.format("%s-%02d-%02d-%d",
                    allocation.yardSlot().block(),
                    allocation.yardSlot().bay(),
                    allocation.yardSlot().row(),
                    allocation.yardSlot().tier()
            );
        }

        return new AllocationResponse(
                allocation.id(),
                isoCode,
                coordinate,
                allocation.arrivalDate(),
                allocation.estimatedDeparture(),
                allocation.actualDeparture(),
                allocation.status()
        );

    }

}
