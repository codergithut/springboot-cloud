package com.service.bill;

import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;

import java.io.IOException;
import java.util.List;

public interface GetHotWorld {
    List<HotWorld> getHotWorld(HotWordRequest hotWordRequest) throws IOException;
}
