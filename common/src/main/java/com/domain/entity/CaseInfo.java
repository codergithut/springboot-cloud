package com.domain.entity;

public class CaseInfo {

    /**
     * 案件名称
     */
    private String name;

    /**
     * 案件编号
     */
    private String method;

    /**
     * 案件时间
     */
    private String Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
