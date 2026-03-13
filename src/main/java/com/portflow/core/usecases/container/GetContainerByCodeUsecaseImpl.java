package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.exceptions.RegisterNotFoundException;
import com.portflow.core.gateway.ContainerGateway;

public class GetContainerByCodeUsecaseImpl implements GetContainerByCodeUsecase {

    private final ContainerGateway containerGateway;

    public GetContainerByCodeUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public Container execute(String isoCode) {
        return containerGateway.getContainerByCode(isoCode)
                .orElseThrow(() -> new RegisterNotFoundException("Container with iso code " + isoCode + " not found."));
    }
}
