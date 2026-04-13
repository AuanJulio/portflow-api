package com.portflow.core.gateway;

import com.portflow.core.domain.Allocation;

import java.util.List;

public interface AllocationGateway {

    public Allocation checkInContainer(String containerIsoCode, Long yardSlotId);

    public void checkOutContainer(String containerIsoCode);

    public List<Allocation> getContainerHistory(String containerIsoCode);

    public Allocation relocateContainer(String containerIsoCode, Long yardSlotId);
}
