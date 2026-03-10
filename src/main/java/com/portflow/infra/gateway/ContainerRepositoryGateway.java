package com.portflow.infra.gateway;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.gateway.ContainerGateway;
import com.portflow.infra.mapper.ContainerEntityMapper;
import com.portflow.infra.persistence.ContainerEntity;
import com.portflow.infra.persistence.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContainerRepositoryGateway implements ContainerGateway {

    private final ContainerRepository containerRepository;

    @Override
    public Container registerContainer(Container container) {
        ContainerEntity containerEntity = ContainerEntityMapper.toEntity(container);
        ContainerEntity savedContainer = containerRepository.save(containerEntity);
        return ContainerEntityMapper.toDomain(savedContainer);
    }

    @Override
    public Container getContainerByCode(String isoCode) {
        ContainerEntity containerEntity = containerRepository.findByIsoCode(isoCode);
        return ContainerEntityMapper.toDomain(containerEntity);
    }

    @Override
    public List<Container> listAllContainers(String clientName, ContainerCategory category) {
        List<ContainerEntity> containers = containerRepository.listAllContainersQuery(clientName, category);
        return containers.stream().map(c -> ContainerEntityMapper.toDomain(c)).toList();
    }

    @Override
    public Container updateContainer(String isoCode, Container container) {
        ContainerEntity containerEntity = containerRepository.findByIsoCode(isoCode);

        if (containerEntity != null) {
            containerEntity.setIsoCode(container.isoCode());
            containerEntity.setCategory(container.category());
            containerEntity.setSize(container.size());
            containerEntity.setTareWeight(container.tareWeight());
            containerEntity.setPayloadWeight(container.payloadWeight());
            containerEntity.setClientName(container.clientName());
            ContainerEntity updatedContainer = containerRepository.save(containerEntity);
            return ContainerEntityMapper.toDomain(updatedContainer);
        } else {
            throw new RuntimeException("Container not found");
        }
    }

    @Override
    public Boolean existsByIsoCode(String isoCode) {
        return containerRepository.existsByIsoCode(isoCode);
    }

}
