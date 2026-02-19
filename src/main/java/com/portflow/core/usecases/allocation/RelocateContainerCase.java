package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;

public interface RelocateContainerCase {

    public Allocation execute(String containerIsoCode, Long yardSlotId);

}
