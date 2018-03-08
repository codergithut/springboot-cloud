package elasticsearch;

import com.domain.message.HotWordRequest;
import org.apache.http.HttpHost;
import org.apache.lucene.util.automaton.RegExp;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.support.IncludeExclude;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.profile.ProfileShardResult;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ElasticSearchClientTest {

    public void testClient(HotWordRequest hotWordRequest) throws IOException {

        Map<String, Long> data = new HashMap<String, Long>();
        RestClient restClient = RestClient.builder(
                new HttpHost("192.168.2.11", 9200, "http")).build();

        RestHighLevelClient client =
                new RestHighLevelClient(restClient);

        SearchRequest searchRequest = new SearchRequest("class");
        searchRequest.types("case");

        RegExp regExp = new RegExp("[\u4e00-\u9fa5]{5,10}");
        IncludeExclude includeExclude = new IncludeExclude(regExp, null);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("event_agg")
                .field("event").size(100).includeExclude(includeExclude);
        searchSourceBuilder.aggregation(aggregation);
        searchSourceBuilder.size(0);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest);

        Map<String, ProfileShardResult> profilingResults = searchResponse.getProfileResults();
        Map<String, Aggregation> aggregations = searchResponse.getAggregations().asMap();
        for (Map.Entry<String, Aggregation> entry : aggregations.entrySet()) {
           System.out.println(entry.getKey());
           Aggregation agg = entry.getValue();
           Class aC = agg.getClass();
           ParsedStringTerms a = (ParsedStringTerms) agg;
           List<Terms.Bucket> t = (List<Terms.Bucket>)a.getBuckets();
           for(Terms.Bucket buket : t) {
               data.put(buket.getKey().toString(), buket.getDocCount());

           }
        }
        System.out.println();

    }

    @Test
    public void haha() {

    }

}
