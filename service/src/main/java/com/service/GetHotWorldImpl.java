package com.service;

import com.api.elasticsearch.ElasticSearchService;
import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;
import com.service.bill.GetHotWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetHotWorldImpl implements GetHotWorld {

    @Autowired
    ElasticSearchService elasticSearchService;

    @Override
    public List<HotWorld> getHotWorld(HotWordRequest hotWordRequest) {
        List<HotWorld> hotWorlds = new ArrayList<HotWorld>();
        //将elasticsearch获取的数据获得
        List<HotWorld> worlds = elasticSearchService.getHotWorld();
        hotWorlds.addAll(worlds);
        //todo: 可能需到其他地方获取数据，比如mongodb等等，反正就是其他数据

        return hotWorlds;
    }

}
