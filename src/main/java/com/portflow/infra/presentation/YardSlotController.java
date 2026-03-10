package com.portflow.infra.presentation;

import com.portflow.infra.request.yardslot.InitializeYardSlotRequest;
import com.portflow.infra.request.yardslot.UpdateMaintenanceRequest;
import com.portflow.infra.response.yardslot.YardSlotResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/yardslots")
public class YardSlotController {

    @PostMapping
    public String initializeYardSlots(@RequestBody InitializeYardSlotRequest request){
        return "";
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
