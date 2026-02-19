package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;

public interface UpdateContainerCase {

    public Container execute(String isoCode, Container container);

}
