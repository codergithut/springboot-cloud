package com.domain.message;

public class HotWordRequest {

    /**
     * 汉字最小长度
     */
    private int begin;

    /**
     * 汉字最大长度
     */
    private int end;

    /**
     * 热词个数
     */
    private int size;

    /**
     * 犯罪类型
     */
    private String caseType;

    /**
     * 需要排除的词多个词用|隔开
     */
    private String exclude;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}
