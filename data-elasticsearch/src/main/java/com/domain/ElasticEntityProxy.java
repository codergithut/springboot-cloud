package com.domain;

import com.alibaba.fastjson.JSON;
import com.domain.entity.GetMainId;

public class ElasticEntityProxy<T extends GetMainId>{

    T proxyEntry;

    private IndexParam index;

    public ElasticEntityProxy(T proxyEntry) {
        this.proxyEntry = proxyEntry;
    }

    public T getProxyEntry() {
        return proxyEntry;
    }

    public void setProxyEntry(T proxyEntry) {
        this.proxyEntry = proxyEntry;
    }

    public IndexParam getIndex() {
        return index;
    }

    public void setIndex(IndexParam index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(proxyEntry);
    }
}
