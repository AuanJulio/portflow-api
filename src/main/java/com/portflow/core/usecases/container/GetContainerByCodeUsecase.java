package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;

public interface GetContainerByCodeUsecase {

    public Container execute(String isoCode);

}
