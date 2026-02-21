package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.gateway.ContainerGateway;

public class UpdateContainerUsecaseImpl implements UpdateContainerUsecase {

    private final ContainerGateway containerGateway;

    public UpdateContainerUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public Container execute(String isoCode, Container container) {
        return containerGateway.updateContainer(isoCode, container);
    }
}
