package com.dao;

import com.config.ConstantParam;
import com.domain.ElasticEntityProxy;
import com.domain.IndexParam;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

    /**
     * @param elasticEntityProxyList 需要插入的elasticsearch数据
     * @throws IOException 数据流异常
     */
    public void bulkAddElasticSearch(List<ElasticEntityProxy> elasticEntityProxyList) throws IOException {

        BulkRequest request = new BulkRequest();

        for(ElasticEntityProxy elasticEntityProxy : elasticEntityProxyList) {
            IndexParam indexParam = elasticEntityProxy.getIndex();
            request.add(new IndexRequest(
                    indexParam.getIndex(),
                    indexParam.getType(),
                    elasticEntityProxy.getProxyEntry().getMainId())
                    .source(XContentType.JSON,elasticEntityProxy.toString()));
        }
        BulkResponse bulkResponse = client.bulk(request);

        for (BulkItemResponse bulkItemResponse : bulkResponse) {
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();

            if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                    || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                IndexResponse indexResponse = (IndexResponse) itemResponse;

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                UpdateResponse updateResponse = (UpdateResponse) itemResponse;

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
            }

            if (bulkItemResponse.isFailed()) {
                BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
            }
        }

    }



}
