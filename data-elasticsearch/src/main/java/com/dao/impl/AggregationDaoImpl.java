package com.dao.impl;

import com.dao.AggregationDao;
import com.domain.AggreationParam;
import com.domain.IndexParam;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.support.IncludeExclude;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 简单的统计查询封装
 */
@Service
public class AggregationDaoImpl implements AggregationDao {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public SearchResponse getAggreationData(IndexParam index, AggreationParam aggreationParam) throws IOException {
        SearchRequest searchRequest = new SearchRequest(index.getIndex());
        searchRequest.types(index.getType());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        if(!aggreationParam.getAggreationType().getName().equals("TERMS")) {
            IncludeExclude includeExclude = new IncludeExclude(aggreationParam.getIncludes(), aggreationParam.getExcludes());

            TermsAggregationBuilder aggregation = AggregationBuilders.terms("aggregation")
                    .field(aggreationParam.getField()).size(aggreationParam.getSize()).includeExclude(includeExclude);
            searchSourceBuilder.aggregation(aggregation);
        }

        searchSourceBuilder.size(0);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
        return searchResponse;
    }
}
