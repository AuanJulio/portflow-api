package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.gateway.ContainerGateway;

import java.util.List;

public class ListAllContainersUsecaseImpl implements ListAllContainersUsecase {

    private final ContainerGateway containerGateway;

    public ListAllContainersUsecaseImpl(ContainerGateway containerGateway) {
        this.containerGateway = containerGateway;
    }

    @Override
    public List<Container> execute(String clientName, ContainerCategory category) {
        return containerGateway.listAllContainers(clientName, category);
    }
}
