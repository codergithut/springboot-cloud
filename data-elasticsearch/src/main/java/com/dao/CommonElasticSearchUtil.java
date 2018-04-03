package com.dao;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 *  通过http方式直接操作es服务的工具方法，批量修改和删除需要通过这个方法来处理
 */
public class CommonElasticSearchUtil {

    public static Response exeElasticSearch(String DSL, String method,String index, RestClient client) throws IOException {
        Map<String, String> params = Collections.emptyMap();
        HttpEntity entity = new NStringEntity(DSL, ContentType.APPLICATION_JSON);
        return client.performRequest(method, index, params, entity);
    }

}
