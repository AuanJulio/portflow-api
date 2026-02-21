package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.gateway.ContainerGateway;

public class GetContainerByCodeUsecaseImpl implements GetContainerByCodeUsecase {

    private final ContainerGateway containerGateway;

    public GetContainerByCodeUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public Container execute(String isoCode) {
        return containerGateway.getContainerByCode(isoCode);
    }
}
