package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;

public interface UpdateContainerUsecase {

    public Container execute(String isoCode, Container container);

}
