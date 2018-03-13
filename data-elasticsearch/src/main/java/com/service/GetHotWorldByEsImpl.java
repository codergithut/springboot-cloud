package com.service;

import com.dao.AggregationDao;
import com.dao.SaveDataToElasticSearch;
import com.domain.AggreationParam;
import com.domain.AggreationType;
import com.domain.ElasticEntityProxy;
import com.domain.IndexParam;
import com.domain.entity.EventInfo;
import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;
import com.service.bill.servcice.GetHotWorldService;
import org.apache.lucene.util.automaton.RegExp;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 通过es获取热门词汇
 */
@RestController
@RequestMapping("/api")
public class GetHotWorldByEsImpl implements GetHotWorldService {

    @Autowired
    AggregationDao aggregationDao;


    @Override
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<HotWorld> getHotWorld(HotWordRequest hotWordRequest1) throws IOException {

        HotWordRequest hotWordRequest = new HotWordRequest();

        hotWordRequest.setBegin(1);
        hotWordRequest.setEnd(6);
        hotWordRequest.setSize(10);

        List<HotWorld> hotWorlds = new ArrayList<HotWorld>();

        RegExp regExp = new RegExp("[\u4e00-\u9fa5]{begin,end}".replace("begin", hotWordRequest.getBegin()+"")
                .replace("end", hotWordRequest.getEnd() + ""));



        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("class");
        indexParam.setType("case");

        AggreationParam aggreationParam = new AggreationParam();
        aggreationParam.setAggreationType(AggreationType.TERMS);
        aggreationParam.setExcludes(null);
        aggreationParam.setIncludes(regExp);
        if(hotWordRequest != null && hotWordRequest.getExclude() != null) {
            RegExp exp = new RegExp(hotWordRequest.getExclude());
            aggreationParam.setExcludes(exp);
        }
        aggreationParam.setField("event");
        aggreationParam.setSize(hotWordRequest.getSize());

        QueryBuilder queryBuilder = QueryBuilders.termQuery("event", "这张电梯上的照片 被暖");
        SearchResponse searchResponse = aggregationDao.getAggreationData(indexParam, aggreationParam, queryBuilder);
        Map<String, Aggregation> aggregations = searchResponse.getAggregations().asMap();
        for (Map.Entry<String, Aggregation> entry : aggregations.entrySet()) {
            Aggregation agg = entry.getValue();
            ParsedStringTerms a = (ParsedStringTerms) agg;
            List<Terms.Bucket> t = (List<Terms.Bucket>)a.getBuckets();
            for(Terms.Bucket buket : t) {
                HotWorld hotWorld = new HotWorld();
                hotWorld.setNumber(buket.getDocCount());
                hotWorld.setWorld(buket.getKey().toString());
                hotWorlds.add(hotWorld);
            }
        }
        return hotWorlds;
    }


    @Autowired
    SaveDataToElasticSearch saveDataToElasticSearch;

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String testElastic() throws IOException {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setId("1111");
        eventInfo.setEvent("测试数据123");
        IndexParam indexParam = new IndexParam();
        indexParam.setType("case");
        indexParam.setIndex("class");
        ElasticEntityProxy elasticEntityProxy = new ElasticEntityProxy(eventInfo);
        elasticEntityProxy.setIndex(indexParam);
        saveDataToElasticSearch.addElasticSearch(elasticEntityProxy);
        return null;
    }


}
