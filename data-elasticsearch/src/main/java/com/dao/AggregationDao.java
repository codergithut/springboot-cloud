package com.dao;

import com.domain.AggreationParam;
import com.domain.IndexParam;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;

/**
 * 统计查询接口
 */
public interface AggregationDao {
    SearchResponse getAggreationData(IndexParam index, AggreationParam aggreationParam) throws IOException;
}
