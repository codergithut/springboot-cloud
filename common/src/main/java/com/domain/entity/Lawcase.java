package com.domain.entity;

import java.util.Date;
import java.util.List;

public class Lawcase {
	private Integer lawcaseId;

	private String lawcaseName;
	
	private String lawcaseType;

	private String lawcaseNo;

	private String lawcaseUploadUser;

	private String lawcaseSendUser;

	private java.util.Date lawcaseCreateTime;
	
	private String lawcaseOrganization;

	private String lawcaseFromZone;
	
	private Integer orgId;
	
	private Integer workId;
	
	private String state;
	
	private Integer secrecy;
	
	private Integer closeCase;
	
	private Integer casetypeId;	
	
	private String remark;	
	
	private List<String> remarkList;
	
	private Integer Authority;

	public Integer getLawcaseId() {
		return lawcaseId;
	}

	public void setLawcaseId(Integer lawcaseId) {
		this.lawcaseId = lawcaseId;
	}

	public String getLawcaseName() {
		return lawcaseName;
	}

	public void setLawcaseName(String lawcaseName) {
		this.lawcaseName = lawcaseName;
	}

	public String getLawcaseType() {
		return lawcaseType;
	}

	public void setLawcaseType(String lawcaseType) {
		this.lawcaseType = lawcaseType;
	}

	public String getLawcaseNo() {
		return lawcaseNo;
	}

	public void setLawcaseNo(String lawcaseNo) {
		this.lawcaseNo = lawcaseNo;
	}

	public String getLawcaseUploadUser() {
		return lawcaseUploadUser;
	}

	public void setLawcaseUploadUser(String lawcaseUploadUser) {
		this.lawcaseUploadUser = lawcaseUploadUser;
	}

	public String getLawcaseSendUser() {
		return lawcaseSendUser;
	}

	public void setLawcaseSendUser(String lawcaseSendUser) {
		this.lawcaseSendUser = lawcaseSendUser;
	}

	public Date getLawcaseCreateTime() {
		return lawcaseCreateTime;
	}

	public void setLawcaseCreateTime(Date lawcaseCreateTime) {
		this.lawcaseCreateTime = lawcaseCreateTime;
	}

	public String getLawcaseOrganization() {
		return lawcaseOrganization;
	}

	public void setLawcaseOrganization(String lawcaseOrganization) {
		this.lawcaseOrganization = lawcaseOrganization;
	}

	public String getLawcaseFromZone() {
		return lawcaseFromZone;
	}

	public void setLawcaseFromZone(String lawcaseFromZone) {
		this.lawcaseFromZone = lawcaseFromZone;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSecrecy() {
		return secrecy;
	}

	public void setSecrecy(Integer secrecy) {
		this.secrecy = secrecy;
	}

	public Integer getCloseCase() {
		return closeCase;
	}

	public void setCloseCase(Integer closeCase) {
		this.closeCase = closeCase;
	}

	public Integer getCasetypeId() {
		return casetypeId;
	}

	public void setCasetypeId(Integer casetypeId) {
		this.casetypeId = casetypeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<String> getRemarkList() {
		return remarkList;
	}

	public void setRemarkList(List<String> remarkList) {
		this.remarkList = remarkList;
	}

	public Integer getAuthority() {
		return Authority;
	}

	public void setAuthority(Integer authority) {
		Authority = authority;
	}
}
