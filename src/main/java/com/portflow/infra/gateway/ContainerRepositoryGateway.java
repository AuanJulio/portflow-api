package com.portflow.infra.gateway;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.gateway.ContainerGateway;
import com.portflow.core.exceptions.RegisterNotFoundException;
import com.portflow.infra.mapper.ContainerEntityMapper;
import com.portflow.infra.persistence.ContainerEntity;
import com.portflow.infra.persistence.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<Container> getContainerByCode(String isoCode) {
        return containerRepository.findByIsoCode(isoCode)
                .map(c -> ContainerEntityMapper.toDomain(c));
    }

    @Override
    public List<Container> listAllContainers(String clientName, ContainerCategory category) {
        List<ContainerEntity> containers = containerRepository.listAllContainersQuery(clientName, category);
        return containers.stream().map(c -> ContainerEntityMapper.toDomain(c)).toList();
    }

    @Override
    public Container updateContainer(String isoCode, Container container) {

        ContainerEntity containerEntity = containerRepository.findByIsoCode(isoCode)
                .orElseThrow(() -> new RegisterNotFoundException("Container with iso code " + isoCode + " not found."));

        containerEntity.setIsoCode(container.isoCode());
        containerEntity.setCategory(container.category());
        containerEntity.setSize(container.size());
        containerEntity.setTareWeight(container.tareWeight());
        containerEntity.setPayloadWeight(container.payloadWeight());
        containerEntity.setClientName(container.clientName());
        ContainerEntity updatedContainer = containerRepository.save(containerEntity);

        return ContainerEntityMapper.toDomain(updatedContainer);
    }

    @Override
    public Boolean existsByIsoCode(String isoCode) {
        return containerRepository.existsByIsoCode(isoCode);
    }

}
