package com.portflow.core.usecases.yardslot;

import com.portflow.core.domain.YardSlot;

import java.util.List;
import java.util.Map;

public interface GetYardStructureUsecase {

    public Map<String, List<YardSlot>> execute();

}
