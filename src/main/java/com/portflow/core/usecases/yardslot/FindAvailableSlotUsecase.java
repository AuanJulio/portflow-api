package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;

public interface FindAvailableSlotUsecase {

    public YardSlot execute(Long yardId);

}
