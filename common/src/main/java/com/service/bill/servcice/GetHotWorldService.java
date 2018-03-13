package com.service.bill.servcice;

import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;

import java.io.IOException;
import java.util.List;

public interface GetHotWorldService {
    List<HotWorld> getHotWorld(HotWordRequest hotWordRequest) throws IOException;
}
