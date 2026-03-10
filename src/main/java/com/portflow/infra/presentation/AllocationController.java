package com.portflow.infra.presentation;

import com.portflow.infra.request.allocation.CheckInRequest;
import com.portflow.infra.request.allocation.RealocateRequest;
import com.portflow.infra.response.allocation.AllocationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    @PostMapping("/checkin")
    public AllocationResponse checkInContainer(@RequestBody CheckInRequest request){
        return null;
    }

    @PostMapping("/{isoCode}/checkout")
    public AllocationResponse checkOutContainer(@PathVariable String isoCode){
        return null;
    }

    @PostMapping("/realocate")
    public AllocationResponse realocateContainer(@RequestBody RealocateRequest request){
        return null;
    }

    @GetMapping("/history/{isoCode}")
    public List<AllocationResponse> getContainerHistory(@PathVariable String isoCode){
        return List.of();
    }

}
