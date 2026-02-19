package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;

public interface FindAvailableSlotCase {

    public YardSlot execute(Long yardId);

}
