package com.portflow.core.gateway;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;

import java.util.List;

public interface ContainerGateway {

    public Container registerContainer(Container container);

    public Container getContainerByCode(String isoCode);

    public List<Container> listAllContainers(String clientName, ContainerCategory category);

    public Container updateContainer(String isoCode, Container container);

}
