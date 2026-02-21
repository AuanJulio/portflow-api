package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.gateway.ContainerGateway;

public class RegisterContainerUsecaseImpl implements RegisterContainerUsecase {

    private final ContainerGateway containerGateway;

    public RegisterContainerUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public Container execute(Container container) {
        return containerGateway.registerContainer(container);
    }
}
