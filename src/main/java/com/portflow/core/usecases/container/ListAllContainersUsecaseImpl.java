package com.portflow.core.usecases.container;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;

import java.util.List;

public class ListAllContainersUsecaseImpl implements ListAllContainersUsecase {
    @Override
    public List<Container> execute(ContainerCategory category) {
        return List.of();
    }
}
