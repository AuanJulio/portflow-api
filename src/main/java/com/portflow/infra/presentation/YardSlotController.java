package com.portflow.infra.presentation;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.usecases.yardslot.InitializeYardBlockUsecase;
import com.portflow.infra.mapper.YardSlotMapper;
import com.portflow.infra.request.yardslot.InitializeYardSlotRequest;
import com.portflow.infra.request.yardslot.UpdateMaintenanceRequest;
import com.portflow.infra.response.yardslot.YardSlotResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/yardslots")
public class YardSlotController {

    private final InitializeYardBlockUsecase initializeYardBlockUsecase;

    public YardSlotController(InitializeYardBlockUsecase initializeYardBlockUsecase) {
        this.initializeYardBlockUsecase = initializeYardBlockUsecase;
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
    public Map<String, List<YardSlotResponse>> getStructure(){
        return Map.of();
    }

    @GetMapping("/available")
    public YardSlotResponse findAvailableSlot(@RequestParam Double containerWeight){
        return null;
    }

    @PatchMapping("/{id}/status")
    public void updateYardSlotStatus(@PathVariable Long id, @RequestBody UpdateMaintenanceRequest request){
    }

}
