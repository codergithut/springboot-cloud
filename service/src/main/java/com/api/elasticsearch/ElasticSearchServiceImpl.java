package com.api.elasticsearch;

import com.domain.ResponseMessage;
import com.domain.entity.HotWorld;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 如果服务不可以用将使用改实现去忽悠用户
 */
@Component
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Override
    public List<HotWorld> getHotWorld() {
        return null;
    }
}
