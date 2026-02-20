package com.portflow.core.usecases.allocation;

import com.portflow.core.domain.Allocation;

import java.util.List;

public interface GetContainerHistoryUsecase {

    public List<Allocation> execute(String containerIsoCode);

}
