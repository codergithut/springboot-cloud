package com.service;

import com.api.elasticsearch.ElasticSearchService;
import com.domain.ResponseMessage;
import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;
import com.service.bill.servcice.GetHotWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetHotWorldClient {

    @Autowired
    ElasticSearchService elasticSearchService;

    public ResponseMessage getHotWorldService() {
        ResponseMessage responseMessage = new ResponseMessage();
        List<HotWorld> hotWorlds = new ArrayList<HotWorld>();
        List<HotWorld> worlds = elasticSearchService.getHotWorld();
        hotWorlds.addAll(worlds);
        //todo: 可能需到其他地方获取数据，比如mongodb等等，反正就是其他数据
        responseMessage.setResult(true);
        responseMessage.setData(hotWorlds);
        return responseMessage;
    }
}
