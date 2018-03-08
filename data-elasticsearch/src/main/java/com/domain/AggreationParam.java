package com.domain;

import org.apache.lucene.util.automaton.RegExp;

public class AggreationParam {

    private RegExp includes;

    private RegExp excludes;

    private AggreationType AggreationType;

    private String field;

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
