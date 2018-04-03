package com.domain;

import org.apache.lucene.util.automaton.RegExp;

public class AggreationParam {

    /**
     * 查询包含的正则式
     */
    private RegExp includes;

    /**
     * 需要排除的正则式
     */
    private RegExp excludes;

    /**
     * 统计类型
     */
    private AggreationType AggreationType;

    /**
     * 需要统计的类型，现在是event字段
     */
    private String field;

    /**
     * 需要返回数据的大小
     */
    private int size;

    public RegExp getIncludes() {
        return includes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setIncludes(RegExp includes) {
        this.includes = includes;
    }

    public RegExp getExcludes() {
        return excludes;
    }

    public void setExcludes(RegExp excludes) {
        this.excludes = excludes;
    }

    public AggreationType getAggreationType() {
        return AggreationType;
    }

    public void setAggreationType(AggreationType aggreationType) {
        AggreationType = aggreationType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
