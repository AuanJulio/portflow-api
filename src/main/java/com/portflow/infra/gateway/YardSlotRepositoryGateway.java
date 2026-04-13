package com.portflow.infra.gateway;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.gateway.YardSlotGateway;
import com.portflow.infra.mapper.YardSlotEntityMapper;
import com.portflow.infra.persistence.YardSlotEntity;
import com.portflow.infra.persistence.YardSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class YardSlotRepositoryGateway implements YardSlotGateway {

    private final YardSlotRepository yardSlotRepository;

    @Override
    public List<YardSlot> initializeYardBlock(String block, Integer totalBays, Integer totalRows, Integer maxTiers, Double maxWeightCapacity) {

        List<YardSlotEntity> yardSlotsToCreate = new ArrayList<>();

        for (int bay = 1; bay <= totalBays; bay++) {
            for (int row = 1; row <= totalRows; row++) {
                for (int tier = 1; tier <= maxTiers; tier++) {

                    YardSlotEntity yardSlot = new YardSlotEntity(
                            null,
                            block,
                            bay,
                            row,
                            tier,
                            maxWeightCapacity,
                            true);

                    yardSlotsToCreate.add(yardSlot);

                }
            }
        }

        List<YardSlotEntity> savedYardSlots = yardSlotRepository.saveAll(yardSlotsToCreate);

        return savedYardSlots.stream()
                .map(ys -> YardSlotEntityMapper.toDomain(ys))
                .toList();
    }

    @Override
    public YardSlot findAvailableSlot(Double containerWeight) {
        List<YardSlotEntity> yardSlots = yardSlotRepository.findAll();

        YardSlotEntity bestYardSlot = yardSlots.stream()
                .filter(y -> y.getIsOperational() == true)
                .filter(slot -> {
                    if (slot.getTier() == 1) {
                        return slot.getMaxWeightCapacity() >= containerWeight;
                    }
                    return true;
                })
                .min(Comparator.comparing(YardSlotEntity::getTier)
                        .thenComparing(YardSlotEntity::getBlock)
                        .thenComparing(YardSlotEntity::getBay)
                        .thenComparing(YardSlotEntity::getRow))
                .orElseThrow(() -> new RuntimeException("No available slots found"));

        return YardSlotEntityMapper.toDomain(bestYardSlot);
    }

    @Override
    public Map<String, List<YardSlot>> getYardStructure() {
        List<YardSlotEntity> yardSlots = yardSlotRepository.findAll();

        return yardSlots.stream()
                .map(y -> YardSlotEntityMapper.toDomain(y))
                .collect(Collectors.groupingBy(y -> y.block()));
    }

    @Override
    public void setSlotMaintenanceStatus(Long slotId, Boolean status) {
        YardSlotEntity yardSlot = yardSlotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        yardSlot.setIsOperational(status);
        yardSlotRepository.save(yardSlot);
    }

}
