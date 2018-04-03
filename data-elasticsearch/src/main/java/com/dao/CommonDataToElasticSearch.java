package com.dao;

import com.domain.IndexParam;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import static com.config.ConstantParam.*;

/**
 * 通用批量删除修改实现
 */
@Service
public class CommonDataToElasticSearch {

    @Autowired
    RestClient client;

    public CommonDataToElasticSearch(RestClient client) {
        this.client = client;
    }

    public CommonDataToElasticSearch() {
    }

    /**
     *
     * @param indexParam 索引信息
     * @param search 查询信息
     * @throws IOException
     */
    public void deleteEsData(IndexParam indexParam, Map<String, String> search) throws IOException {
        String deleteDSL = DELETE_SEARCH.replace("$searchParam", search.get("searchParam"))
                .replace("$searchValue",search.get("searchValue"));
        CommonElasticSearchUtil.exeElasticSearch(deleteDSL, "POST", indexParam.getIndex() +  DELETE_PLUGIN, client);
    }

    /**
     *
     * @param indexParam 索引信息
     * @param paramsValue 跟新信息
     * @throws IOException
     */
    public void updateEsData(IndexParam indexParam, Map<String,String> paramsValue) throws IOException {
        String updateDSL = UPDATE_SEARCH.replace("$param", paramsValue.get("param")).replace("$value", paramsValue.get("value"))
                .replace("$searchValue", paramsValue.get("searchValue")).replace("$searchParam", paramsValue.get("searchParam"));
        CommonElasticSearchUtil.exeElasticSearch(updateDSL, "POST", indexParam.getIndex() + UPDATE_PLUGIN, client);


    }
}
