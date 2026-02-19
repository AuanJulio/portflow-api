package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;

import java.util.List;

public class GetContainerHistoryCaseImpl implements GetContainerHistoryCase {
    @Override
    public List<Allocation> execute(String containerIsoCode) {
        return List.of();
    }
}
