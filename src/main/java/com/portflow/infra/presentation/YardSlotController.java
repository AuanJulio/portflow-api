package com.portflow.infra.presentation;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.usecases.yardslot.FindAvailableSlotUsecase;
import com.portflow.core.usecases.yardslot.GetYardStructureUsecase;
import com.portflow.core.usecases.yardslot.InitializeYardBlockUsecase;
import com.portflow.core.usecases.yardslot.SetSlotMaintenanceStatusUsecase;
import com.portflow.infra.mapper.YardSlotMapper;
import com.portflow.infra.request.yardslot.InitializeYardSlotRequest;
import com.portflow.infra.request.yardslot.UpdateMaintenanceRequest;
import com.portflow.infra.response.yardslot.YardSlotResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/yardslots")
public class YardSlotController {

    private final InitializeYardBlockUsecase initializeYardBlockUsecase;

    private final FindAvailableSlotUsecase findAvailableSlotUsecase;

    private final GetYardStructureUsecase getYardStructureUsecase;

    private final SetSlotMaintenanceStatusUsecase setSlotMaintenanceStatusUsecase;

    public YardSlotController(InitializeYardBlockUsecase initializeYardBlockUsecase,
                              FindAvailableSlotUsecase findAvailableSlotUsecase,
                              GetYardStructureUsecase getYardStructureUsecase,
                              SetSlotMaintenanceStatusUsecase setSlotMaintenanceStatusUsecase) {
        this.initializeYardBlockUsecase = initializeYardBlockUsecase;
        this.findAvailableSlotUsecase = findAvailableSlotUsecase;
        this.getYardStructureUsecase = getYardStructureUsecase;
        this.setSlotMaintenanceStatusUsecase = setSlotMaintenanceStatusUsecase;
    }

    @PostMapping
    public ResponseEntity<List<YardSlotResponse>> initializeYardSlots(@RequestBody InitializeYardSlotRequest request){
        List<YardSlot> initializedYardSlots = initializeYardBlockUsecase.execute(
                request.block(),
                request.totalBays(),
                request.totalRows(),
                request.maxTiers(),
                request.maxWeightCapacity());

        List<YardSlotResponse> yardSlots = initializedYardSlots.stream()
                .map(ys -> YardSlotMapper.toResponse(ys))
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(yardSlots);
    }

    @GetMapping
    public ResponseEntity<Map<String, List<YardSlotResponse>>> getStructure() {
        Map<String, List<YardSlot>> yardSlots = getYardStructureUsecase.execute();

        Map<String, List<YardSlotResponse>> response = yardSlots.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(YardSlotMapper::toResponse)
                                .toList()
                ));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/available")
    public ResponseEntity<YardSlotResponse> findAvailableSlot(@RequestParam Double containerWeight){
        YardSlot yardSlot = findAvailableSlotUsecase.execute(containerWeight);
        return ResponseEntity.status(HttpStatus.OK).body(YardSlotMapper.toResponse(yardSlot));
    }

    @PatchMapping("/{id}/status")
    public void updateYardSlotStatus(@PathVariable Long id, @RequestBody UpdateMaintenanceRequest request){
        setSlotMaintenanceStatusUsecase.execute(id, request.isOperational());
    }

}
