package com.service;

import com.dao.AggregationDao;
import com.dao.CommonDataToElasticSearch;
import com.dao.SaveDataToElasticSearch;
import com.domain.AggreationParam;
import com.domain.AggreationType;
import com.domain.IndexParam;
import com.domain.bean.CaseTypeFilter;
import com.domain.bean.CaseTypeSensitive;
import com.domain.bean.PackType;
import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;
import com.repositories.CaseTypeFilterRepository;
import com.repositories.CaseTypeSensitiveRepository;
import com.repositories.PackTypeRepository;
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
import java.util.*;

/**
 * 通过es获取热门词汇
 */
@RestController
@RequestMapping("/api")
public class GetHotWorldByEsImpl implements GetHotWorldService {

    @Autowired
    AggregationDao aggregationDao;

    @Autowired
    PackTypeRepository packTypeRepository;

    @Autowired
    CommonDataToElasticSearch commonDataToElasticSearch;

    @Autowired
    CaseTypeFilterRepository caseTypeFilterRepository;

    @Autowired
    CaseTypeSensitiveRepository caseTypeSensitiveRepository;

    @Override
    @RequestMapping(value = "/hotWorld",method = RequestMethod.POST)
    public List<HotWorld> getHotWorld(
            HotWordRequest hotWordRequest
    ) throws IOException {

        List<HotWorld> hotWorlds = new ArrayList<HotWorld>();

        RegExp regExp = new RegExp("[\u4e00-\u9fa5]{begin,end}".replace("begin", hotWordRequest.getBegin()+"")
                .replace("end", hotWordRequest.getEnd() + ""));
        RegExp regExp1 = new RegExp(getIgnoreWords());
        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        indexParam.setType("hotword");
        AggreationParam aggreationParam = new AggreationParam();
        aggreationParam.setAggreationType(AggreationType.TERMS);
        aggreationParam.setExcludes(regExp1);
        aggreationParam.setIncludes(regExp);
        if(hotWordRequest != null && hotWordRequest.getExclude() != null) {
            RegExp exp = new RegExp(hotWordRequest.getExclude());
            aggreationParam.setExcludes(exp);
        }
        aggreationParam.setField("event");
        aggreationParam.setSize(hotWordRequest.getSize());

        QueryBuilder queryBuilder = QueryBuilders.matchQuery("tag", hotWordRequest.getCaseType());

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


    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public Object ss() throws IOException {

        List<PackType> packTypes = packTypeRepository.findByUpdateFlag("1");
        for(PackType packType : packTypes) {
            if(packType.getCaseType().equals("0")) {
                updateDataEs(packType);
            } else if (packType.getCaseType().equals("1")) {
                deleteDataEs(packType);
            }
            packType.setUpdateFlag("1");
            packTypeRepository.save(packType);
        }
        return packTypes;
    }

    @RequestMapping(value = "/update1",method = RequestMethod.GET)
    public String test() throws IOException {
        return "ss";
    }

    private boolean updateDataEs(PackType packType) throws IOException {
        Map<String, String> paramsValue = new HashMap<String,String>();
        paramsValue.put("param", "tag");
        paramsValue.put("value", packType.getType());
        paramsValue.put("searchParam", "deviceID");
        paramsValue.put("searchValue", packType.getPackId());
        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        commonDataToElasticSearch.updateEsData(indexParam, paramsValue);
        return true;
    }

    private boolean deleteDataEs(PackType packType) throws IOException {
        Map<String, String> search = new HashMap<String,String>();
        search.put("searchParam", "deviceID");
        search.put("searchValue", packType.getPackId());
        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        commonDataToElasticSearch.deleteEsData(indexParam, search);
        return true;
    }

    private String getIgnoreWords() {

        StringBuffer stringBuffer = new StringBuffer();

        List<CaseTypeFilter> caseTypeFilters = caseTypeFilterRepository.findAll();

        if(caseTypeFilters != null) {
            for(CaseTypeFilter caseTypeFilter : caseTypeFilters) {
                stringBuffer.append(caseTypeFilter.getFilterWords() + "|");
            }
        }

        List<CaseTypeSensitive> caseTypeSensitives = caseTypeSensitiveRepository.findAll();

        if(caseTypeSensitives != null) {
            for(CaseTypeSensitive caseTypeSensitive : caseTypeSensitives) {
                stringBuffer.append(caseTypeSensitive.getSensitiveWords() + "|");
            }
        }
        String value = stringBuffer.toString();
        String reg = value.substring(0, value.length() - 1);
        return reg;
    }

}
