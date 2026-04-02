package com.portflow.infra.gateway;

import com.portflow.core.domain.YardSlot;
import com.portflow.core.gateway.YardSlotGateway;
import com.portflow.infra.mapper.YardSlotEntityMapper;
import com.portflow.infra.persistence.YardSlotEntity;
import com.portflow.infra.persistence.YardSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

}
