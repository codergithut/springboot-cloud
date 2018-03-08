package com.api.elasticsearch;

import com.config.FullLogConfiguration;
import com.domain.ResponseMessage;
import com.domain.entity.HotWorld;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@FeignClient(value = "data-elasticsearch",configuration = FullLogConfiguration.class, fallback = ElasticSearchServiceImpl.class)
public interface ElasticSearchService {

    @RequestMapping(value = "/api/test",method = RequestMethod.GET)
    List<HotWorld> getHotWorld();

}
