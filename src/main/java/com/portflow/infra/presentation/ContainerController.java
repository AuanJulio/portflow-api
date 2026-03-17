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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> registerContainer(@RequestBody ContainerRequest container){
        Container newContainer = registerContainerUsecase.execute(ContainerMapper.toDomain(container));
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Container registered successfully");
        response.put("container: ", ContainerMapper.toResponse(newContainer));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{isoCode}")
    public ResponseEntity<ContainerResponse> updateContainer(@PathVariable String isoCode, @RequestBody ContainerRequest container){
        Container containerToUpdate = ContainerMapper.toDomain(container);
        Container updatedContainer = updateContainerUsecase.execute(isoCode, containerToUpdate);
        ContainerResponse containerResponse = ContainerMapper.toResponse(updatedContainer);
        return ResponseEntity.status(HttpStatus.OK).body(containerResponse);
    }

    @GetMapping("/{isoCode}")
    public ResponseEntity<ContainerResponse> getContainer(@PathVariable String isoCode){
        Container container = getContainerByCodeUsecase.execute(isoCode);
        ContainerResponse containerResponse = ContainerMapper.toResponse(container);
        return ResponseEntity.status(HttpStatus.OK).body(containerResponse);
    }

    @GetMapping
    public ResponseEntity<List<ContainerResponse>> getAllContainers(
            @RequestParam(required = false) String clientName,
            @RequestParam(required = false) ContainerCategory category){
        List<Container> containers = listAllContainersUsecase.execute(clientName, category);
        List<ContainerResponse> lstContainerResponse = containers.stream()
                .map(c -> ContainerMapper.toResponse(c))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(lstContainerResponse);
    }

}
