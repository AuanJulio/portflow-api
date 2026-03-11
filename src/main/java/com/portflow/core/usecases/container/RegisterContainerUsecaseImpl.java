package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.gateway.ContainerGateway;
import com.portflow.core.exceptions.DuplicatedContainerException;

public class RegisterContainerUsecaseImpl implements RegisterContainerUsecase {

    private final ContainerGateway containerGateway;

    public RegisterContainerUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public Container execute(Container container) {
        if (containerGateway.existsByIsoCode(container.isoCode())) {
            throw new DuplicatedContainerException("The container with iso code " + container.isoCode() + " already exists.");
        }

        return containerGateway.registerContainer(container);
    }
}
