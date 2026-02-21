package com.portflow.infra.presentation;

import com.portflow.core.domain.Container;
import com.portflow.core.domain.enums.ContainerCategory;
import com.portflow.core.usecases.container.GetContainerByCodeUsecase;
import com.portflow.core.usecases.container.ListAllContainersUsecase;
import com.portflow.core.usecases.container.RegisterContainerUsecase;
import com.portflow.core.usecases.container.UpdateContainerUsecase;
import com.portflow.infra.mapper.ContainerMapper;
import com.portflow.infra.request.container.ContainerRequest;
import com.portflow.infra.response.container.ContainerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/containers")
public class ContainerController {

    private final RegisterContainerUsecase registerContainerUsecase;
    private final UpdateContainerUsecase updateContainerUsecase;
    private final GetContainerByCodeUsecase getContainerByCodeUsecase;
    private final ListAllContainersUsecase listAllContainersUsecase;

    public ContainerController(RegisterContainerUsecase registerContainerUsecase, UpdateContainerUsecase updateContainerUsecase, GetContainerByCodeUsecase getContainerByCodeUsecase, ListAllContainersUsecase listAllContainersUsecase) {
        this.registerContainerUsecase = registerContainerUsecase;
        this.updateContainerUsecase = updateContainerUsecase;
        this.getContainerByCodeUsecase = getContainerByCodeUsecase;
        this.listAllContainersUsecase = listAllContainersUsecase;
    }

    @PostMapping
    public ContainerResponse registerContainer(@RequestBody ContainerRequest container){
        Container newContainer = registerContainerUsecase.execute(ContainerMapper.toDomain(container));
        return ContainerMapper.toResponse(newContainer);
    }

    @PutMapping("/{isoCode}")
    public ContainerResponse updateContainer(@PathVariable String isoCode, @RequestBody ContainerRequest container){
        Container containerToUpdate = ContainerMapper.toDomain(container);
        Container updatedContainer = updateContainerUsecase.execute(isoCode, containerToUpdate);
        return ContainerMapper.toResponse(updatedContainer);
    }

    @GetMapping("/{isoCode}")
    public ContainerResponse getContainer(@PathVariable String isoCode){
        Container container = getContainerByCodeUsecase.execute(isoCode);
        return ContainerMapper.toResponse(container);
    }

    @GetMapping
    public List<ContainerResponse> getAllContainers(
            @RequestParam(required = false) String clientName,
            @RequestParam(required = false) ContainerCategory category){
        List<Container> containers = listAllContainersUsecase.execute(clientName, category);

        return containers.stream()
                .map(c -> ContainerMapper.toResponse(c))
                .toList();
    }

}
