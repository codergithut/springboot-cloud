package com.domain.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "case_type_filter")
public class CaseTypeFilter {

    @Id
    private String id;

    @Column(name = "case_type_id")
    private String caseTypeId;

    @Column(name = "filter_words")
    private String filterWords;

    @Column(name = "create_time")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseTypeId() {
        return caseTypeId;
    }

    public void setCaseTypeId(String caseTypeId) {
        this.caseTypeId = caseTypeId;
    }

    public String getFilterWords() {
        return filterWords;
    }

    public void setFilterWords(String filterWords) {
        this.filterWords = filterWords;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
