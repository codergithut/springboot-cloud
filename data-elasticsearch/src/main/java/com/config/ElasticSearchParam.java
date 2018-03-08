package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchParam {

    /**
     * elasticsearch 服务地址
     */
    @Value("${elasticsearch.host}")
    private String host;

    /**
     * 集群名称默认是：elasticsearch
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * http 服务端口
     */
    @Value("${elasticsearch.http.port}")
    private Integer httpPort;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }
}
