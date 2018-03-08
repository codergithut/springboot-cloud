package com.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ElasticSearchParam.class)
public class ElasticSearchConfig {

    @Autowired
    ElasticSearchParam elasticSearchParam;

    @Bean
    public RestHighLevelClient getRestHighLevelClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost(elasticSearchParam.getHost(), elasticSearchParam.getHttpPort(), ConstantParam.ELASTICSEARCH_SCHEME)).build();
        RestHighLevelClient client =
                new RestHighLevelClient(restClient);
        return client;
    }
}
