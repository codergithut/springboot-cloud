package com.dao;

import com.domain.ElasticEntityProxy;
import com.domain.IndexParam;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SaveDataToElasticSearch {

    @Autowired
    RestHighLevelClient client;

    public SaveDataToElasticSearch() {
    }

    public SaveDataToElasticSearch(RestHighLevelClient client) {
        this.client = client;
    }

    /**
     * @param elasticEntityProxy 需要添加es服务的数据
     * @throws IOException
     */
    public void addElasticSearch(ElasticEntityProxy elasticEntityProxy) throws IOException {
        IndexParam indexParam = elasticEntityProxy.getIndex();
        IndexRequest request = new IndexRequest(
                indexParam.getIndex(),
                indexParam.getType(),
                elasticEntityProxy.getProxyEntry().getMainId());
        request.source(elasticEntityProxy.toString(), XContentType.JSON);
        IndexResponse response =  client.index(request);
        System.out.println();
    }



}
