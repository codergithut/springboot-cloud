package com.domain;

import java.util.Date;

/**
 * 响应消息封装
 */
public class ResponseMessage {

    /**
     * 消息返回码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean result;

    /**
     * 消息数据
     */
    private Object data;

    /**
     * 响应时间
     */
    private Date date;

    /**
     * 业务编号
     */
    private int serviceCode;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
