package com.service.bill.dao;

import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;

import java.io.IOException;
import java.util.List;

public interface HotWorldDao {
    List<HotWorld> getHotWorld(HotWordRequest hotWordRequest) throws IOException;
}
