package com.portflow.core.gateway;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;

import java.util.List;
import java.util.Optional;

public interface ContainerGateway {

    public Container registerContainer(Container container);

    public Optional<Container> getContainerByCode(String isoCode);

    public List<Container> listAllContainers(String clientName, ContainerCategory category);

    public Container updateContainer(String isoCode, Container container);

    public Boolean existsByIsoCode(String isoCode);

}
