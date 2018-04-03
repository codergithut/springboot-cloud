package elasticsearch;

import com.config.ConstantParam;
import com.dao.AggregationDao;
import com.dao.CommonDataToElasticSearch;
import com.dao.SaveDataToElasticSearch;
import com.dao.impl.AggregationDaoImpl;
import com.domain.AggreationParam;
import com.domain.AggreationType;
import com.domain.ElasticEntityProxy;
import com.domain.IndexParam;
import com.domain.entity.EventInfo;
import com.domain.entity.HotWorld;
import com.domain.message.HotWordRequest;
import org.apache.http.HttpHost;
import org.apache.lucene.util.automaton.RegExp;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ElasticSearchClientTest {

    CommonDataToElasticSearch commonDataToElasticSearch;

    AggregationDao aggregationDao;

    SaveDataToElasticSearch saveDataToElasticSearch;

    @Before
    public void initData() {
        RestClient restClient = RestClient.builder(
                new HttpHost("192.168.2.11", 9200, ConstantParam.ELASTICSEARCH_SCHEME)).build();
        commonDataToElasticSearch = new CommonDataToElasticSearch(restClient);

        RestHighLevelClient client =
                new RestHighLevelClient(restClient);
        aggregationDao = new AggregationDaoImpl(client);

        saveDataToElasticSearch = new SaveDataToElasticSearch(client);

    }

    public void addEsData() throws IOException {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setId("1");
        eventInfo.setDeviceID(56719);
        eventInfo.setEvent("测试数据123");
        eventInfo.setTag("43 22 66");
        IndexParam indexParam = new IndexParam();
        indexParam.setType("hotword");
        indexParam.setIndex("case");
        ElasticEntityProxy elasticEntityProxy = new ElasticEntityProxy(eventInfo);
        elasticEntityProxy.setIndex(indexParam);
        saveDataToElasticSearch.addElasticSearch(elasticEntityProxy);

    }

    /**
     * param 更新的参数
     * value 需要跟新的值
     * searchParam 查询的字段
     * searchValue 查询字段的值
     * @throws IOException
     */
    @Test
    public void updataEsData() throws IOException {
        //addEsData();
        Map<String, String> paramsValue = new HashMap<String,String>();
        paramsValue.put("param", "tag");
        paramsValue.put("value", "99");
        paramsValue.put("searchParam", "deviceID");
        paramsValue.put("searchValue", "56719");
        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        commonDataToElasticSearch.updateEsData(indexParam, paramsValue);
    }

    /**
     * searchParam  查询条件参数
     * searchValue  查询条件值
     * @throws IOException
     */
    @Test
    public void deleteEsData() throws IOException {
        //addEsData();
        Map<String, String> search = new HashMap<String,String>();
        search.put("searchParam", "deviceID");
        search.put("searchValue", "56719");
        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        commonDataToElasticSearch.deleteEsData(indexParam, search);
    }

    /**
     * 获取热词信息
     * @throws IOException
     */
    @Test
    public void getHotWorld() throws IOException {

        addEsData();

        HotWordRequest hotWordRequest = new HotWordRequest();

        hotWordRequest.setBegin(1);
        hotWordRequest.setEnd(6);
        hotWordRequest.setSize(10);
        hotWordRequest.setCaseType("43 76");

        List<HotWorld> hotWorlds = new ArrayList<HotWorld>();

        RegExp regExp = new RegExp("[\u4e00-\u9fa5]{begin,end}".replace("begin", hotWordRequest.getBegin()+"")
                .replace("end", hotWordRequest.getEnd() + ""));

        IndexParam indexParam = new IndexParam();
        indexParam.setIndex("case");
        indexParam.setType("hotword");

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

        /**
         * 定义统计的查询条件 tag 多个用空格隔开比如' 72 73  '
         */
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
        for(HotWorld hot : hotWorlds) {
            System.out.println(hot.getWorld());
        }
    }


}
