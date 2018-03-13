package com.domain.entity;

import java.util.Date;

public class Pack {

	private Integer packId;
	private String packName;
	private String packNo;
	private String packSize;
	private String packSum;
	private String packPath;
	private Date packUploadTime;
	private Integer lawcaseId;
	private Integer suspectId;
	private String materialLocalNum;
	private String materialRemarks;
	private String collectTargetId;
	private String imeiEsnMeid;
	private String mac;
	private String bluetoothMac;
	private String manufacturer;
	private String model;
	private String characteristicDesc;
	private String deviceDisplayName;
	private String deviceSerialNum;
	private String deviceOs;
	private String collectSoftware;
	private String collectPoliceName;
	private String collectPoliceId;
	private String targetName;
	private String mobile;
	private String targetCertificateType;
	private String targetCertificateCode;
	private String jiandinghao;
	private String jiandingdi;
	private Date createTime;
	private String uploadUser;
	private String lawcaseName;
	private String imsi;
	private String iccid;
	private String organization;
	private Integer mobileInfoFlag;
	private String suspectName;
	private String suspectIdNumber;
	private String uploadPackCount;
	private String duowei_id;
	private String duowei_cjbh;
	
	
	public String getUploadPackCount() {
		return uploadPackCount;
	}
	public void setUploadPackCount(String uploadPackCount) {
		this.uploadPackCount = uploadPackCount;
	}
	public Integer getPackId() {
		return packId;
	}
	public void setPackId(Integer packId) {
		this.packId = packId;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getPackNo() {
		return packNo;
	}
	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public String getPackSum() {
		return packSum;
	}
	public void setPackSum(String packSum) {
		this.packSum = packSum;
	}
	public String getPackPath() {
		return packPath;
	}
	public void setPackPath(String packPath) {
		this.packPath = packPath;
	}
	public Date getPackUploadTime() {
		return packUploadTime;
	}
	public void setPackUploadTime(Date packUploadTime) {
		this.packUploadTime = packUploadTime;
	}
	public Integer getLawcaseId() {
		return lawcaseId;
	}
	public void setLawcaseId(Integer lawcaseId) {
		this.lawcaseId = lawcaseId;
	}
	public Integer getSuspectId() {
		return suspectId;
	}
	public void setSuspectId(Integer suspectId) {
		this.suspectId = suspectId;
	}
	public String getMaterialLocalNum() {
		return materialLocalNum;
	}
	public void setMaterialLocalNum(String materialLocalNum) {
		this.materialLocalNum = materialLocalNum;
	}
	public String getMaterialRemarks() {
		return materialRemarks;
	}
	public void setMaterialRemarks(String materialRemarks) {
		this.materialRemarks = materialRemarks;
	}
	public String getCollectTargetId() {
		return collectTargetId;
	}
	public void setCollectTargetId(String collectTargetId) {
		this.collectTargetId = collectTargetId;
	}
	public String getImeiEsnMeid() {
		if(imeiEsnMeid!=null){
			imeiEsnMeid=imeiEsnMeid.replace("[","").replace("]","").replaceAll("\"","");
		}
		return imeiEsnMeid;
	}
	public void setImeiEsnMeid(String imeiEsnMeid) {
		this.imeiEsnMeid = imeiEsnMeid;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getBluetoothMac() {
		return bluetoothMac;
	}
	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCharacteristicDesc() {
		return characteristicDesc;
	}
	public void setCharacteristicDesc(String characteristicDesc) {
		this.characteristicDesc = characteristicDesc;
	}
	public String getDeviceDisplayName() {
		return deviceDisplayName;
	}
	public void setDeviceDisplayName(String deviceDisplayName) {
		this.deviceDisplayName = deviceDisplayName;
	}
	public String getDeviceSerialNum() {
		return deviceSerialNum;
	}
	public void setDeviceSerialNum(String deviceSerialNum) {
		this.deviceSerialNum = deviceSerialNum;
	}
	public String getDeviceOs() {
		return deviceOs;
	}
	public void setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
	}
	public String getCollectSoftware() {
		return collectSoftware;
	}
	public void setCollectSoftware(String collectSoftware) {
		this.collectSoftware = collectSoftware;
	}
	public String getCollectPoliceName() {
		return collectPoliceName;
	}
	public void setCollectPoliceName(String collectPoliceName) {
		this.collectPoliceName = collectPoliceName;
	}
	public String getCollectPoliceId() {
		return collectPoliceId;
	}
	public void setCollectPoliceId(String collectPoliceId) {
		this.collectPoliceId = collectPoliceId;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTargetCertificateType() {
		return targetCertificateType;
	}
	public void setTargetCertificateType(String targetCertificateType) {
		this.targetCertificateType = targetCertificateType;
	}
	public String getTargetCertificateCode() {
		return targetCertificateCode;
	}
	public void setTargetCertificateCode(String targetCertificateCode) {
		this.targetCertificateCode = targetCertificateCode;
	}
	public String getJiandinghao() {
		return jiandinghao;
	}
	public void setJiandinghao(String jiandinghao) {
		this.jiandinghao = jiandinghao;
	}
	public String getJiandingdi() {
		return jiandingdi;
	}
	public void setJiandingdi(String jiandingdi) {
		this.jiandingdi = jiandingdi;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public String getLawcaseName() {
		return lawcaseName;
	}
	public void setLawcaseName(String lawcaseName) {
		this.lawcaseName = lawcaseName;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Integer getMobileInfoFlag() {
		return mobileInfoFlag;
	}
	public void setMobileInfoFlag(Integer mobileInfoFlag) {
		this.mobileInfoFlag = mobileInfoFlag;
	}
	public String getSuspectName() {
		return suspectName;
	}
	public void setSuspectName(String suspectName) {
		this.suspectName = suspectName;
	}
	public String getSuspectIdNumber() {
		return suspectIdNumber;
	}
	public void setSuspectIdNumber(String suspectIdNumber) {
		this.suspectIdNumber = suspectIdNumber;
	}
	public String getDuowei_id() {
		return duowei_id;
	}
	public void setDuowei_id(String duowei_id) {
		this.duowei_id = duowei_id;
	}
	public String getDuowei_cjbh() {
		return duowei_cjbh;
	}
	public void setDuowei_cjbh(String duowei_cjbh) {
		this.duowei_cjbh = duowei_cjbh;
	}
	
	
	
	
}