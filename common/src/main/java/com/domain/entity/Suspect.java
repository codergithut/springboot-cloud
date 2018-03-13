package com.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Suspect {

	private Integer id;
	private String name;
	private String sex;
	private String mobile;
	private String idNumber;
	private String  nation;
	private String race;
	private String origin;
	private String address;
	private String post;
	private String bankCard;
	private Integer lawcaseId;
	private String lawcaseName;
	private String duty;
	private Date createTime;
	private Date updateTime;
	private Integer accountId;
	private Integer crimeTypeId;
	private String crimeTypeName;
	private List<String> mobiles;
	private String suspectRemark;
	private Date odpsTime;
	private int personFlag;
	private int hotelFlag;
	private int flightFlag;
	private int trainFlag;
	private int internetFlag; //网吧信息
	private int mobileInfoFlag; //对方号码信息
	private int duoweiFlag; //多维同步情况   默认0    1、有多维数据未同步 2、多维数据线程排队中3、多维数据同步中 4、多维数据以同步 
	private int hailiangFlag; //海量同步情况
	private String education;   //学历
	private String escuage; //兵役情况
	private String workplace;//服务场所
	private String identity;//人口信息
	private String alias;//别名
	private String marry;
	private String work_trip;
	private String work_time;
	private String salary;
	private String state;// 嫌疑人在案件中的状态
	private String total;
	private String orgName;
	private String theft;
	private String poison;
	private String number;
	private String relation;
	private String source;
	private Integer packId;
	private String mac;
	private String imsi;
	private String imeiEsnMeid;
	private String bluetoothMac;
	private String modelResult;
	private String broadBand;//居住地宽带账号
	private String criminalRecord;//前科
	private String carryBankCard;//随身银行卡
	private String foothold;//在温落脚点
	private String lifeHobby;//生活爱好
	private String consumptiveHabit;//消费习惯
	private String mobileUsage;//手机使用
	private String networkBehavior;//网络行为
	private String caseSpaceTime;//对应案件时空
	private String mobileAndCaseRelation;//案前手机和案件时空对应关系
	private String vehicle;//作案交通工具
	private String selectTime;//选择时段
	private String crimeOperandi;//作案手段
	private String selectTarget;//选择目标
	private String selectTool;//选择工具
	private String crimeToolSource;//作案工具来源
	private String crossRegion;//是否跨区域
	private String partnerCase;//同伙情况
	private String commitInCrime;//作案时通联方式
	private String cant;//通联黑话
	private String escapeCode;//逃离方式
	private String stayAfterCase;//案后落脚
	private String disposalMode;//销脏方式
	private String disposalTime;//销脏时间
	private String digNo;
	private String qq;
	private int modelFlag; //1毒 2盗
	private int txlFlag;	//txl_flag
	private int thjlFlag;	//thjl_flag
	private int dxFlag;		//dx_flag
	private int qqFlag;		//qq_flag
	private int wxFlag;		//wx_flag
	private String workTrip;
	private String workTime;
	private String personClass;
    private String age;
	private String educationDegree;
	private String religion;
	private String fingerprintNo;
	private String DNANO;
	private String caseIncluded;
	private String criminalName;
	private String criminalNo;
	private String paramKey;
	private String paramValue;
	private String birthday;
	private String wechat;
	private String caseTime;
	private String orgStr;
	private String relativer;
	private int modelPoint;
	private int packNum;
	private String packNameStr;
	private int modelPointDrugs;
	private int modelPointStael;
	

	public Suspect() {
		super();
	}

	public String getSuspectRemark() {
		return suspectRemark;
	}
	public void setSuspectRemark(String suspectRemark) {
		this.suspectRemark = suspectRemark;
	}
	public String getRelativer() {
		return relativer;
	}
	public void setRelativer(String relativer) {
		this.relativer = relativer;
	}
	public String getCaseTime() {
		return caseTime;
	}
	public void setCaseTime(String caseTime) {
		this.caseTime = caseTime;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getDigNo() {
		return digNo;
	}
	public void setDigNo(String digNo) {
		this.digNo = digNo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getParamKey() {
		return paramKey;
	}
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getEducationDegree() {
		return educationDegree;
	}
	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getFingerprintNo() {
		return fingerprintNo;
	}
	public void setFingerprintNo(String fingerprintNo) {
		this.fingerprintNo = fingerprintNo;
	}
	public String getDNANO() {
		return DNANO;
	}
	public void setDNANO(String dNANO) {
		DNANO = dNANO;
	}
	public String getCaseIncluded() {
		return caseIncluded;
	}
	public void setCaseIncluded(String caseIncluded) {
		this.caseIncluded = caseIncluded;
	}
	public String getCriminalRecord() {
		return criminalRecord;
	}
	public void setCriminalRecord(String criminalRecord) {
		this.criminalRecord = criminalRecord;
	}
	public String getCriminalName() {
		return criminalName;
	}
	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}
	public String getCriminalNo() {
		return criminalNo;
	}
	public void setCriminalNo(String criminalNo) {
		this.criminalNo = criminalNo;
	}
	public Integer getLawcaseId() {
		return lawcaseId;
	}
	public void setLawcaseId(Integer lawcaseId) {
		this.lawcaseId = lawcaseId;
	}
	public Integer getPackId() {
		return packId;
	}
	public void setPackId(Integer packId) {
		this.packId = packId;
	}
	
	
	public String getWorkTrip() {
		return workTrip;
	}
	public void setWorkTrip(String workTrip) {
		this.workTrip = workTrip;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
 
	public Integer getCrimeTypeId() {
		return crimeTypeId;
	}
	public void setCrimeTypeId(Integer crimeTypeId) {
		this.crimeTypeId = crimeTypeId;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;

		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {

		this.idNumber = idNumber;
		String age="";
		String dates="";
		if(idNumber !=null && !idNumber.equals("")){//输入身份证号不为空
			int leh=idNumber.length();
			 SimpleDateFormat df = new SimpleDateFormat("yyyy");
	            String year=df.format(new Date());
	        if (leh == 18) {//18位
	        	
	        	//String newId=idNumber.substring(leh - 1);
	            //int se = Integer.valueOf(newId) % 2;
	            dates = idNumber.substring(6, 10);
	            String two=dates.substring(0, 2);
	            if(two.equals("19")||two.equals("20") ){
		           
		            age=String.valueOf(Integer.parseInt(year)-Integer.parseInt(dates));
		            this.setAge(age);
	            }else{
	            	this.setAge("身份证号码有误");
	            }

	        }else if(leh == 15){//15位
	            dates = idNumber.substring(6, 8);
	            age=String.valueOf(Integer.parseInt(year)-Integer.parseInt("19"+dates));
	            this.setAge(age);
	        }else{
	        	
	        	this.setAge("身份证号码有误");
	        }
		}else{
			
			this.setAge("无身份证号码");
		}
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public List<String> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLawcaseName() {
		return lawcaseName;
	}
	public void setLawcaseName(String lawcaseName) {
		this.lawcaseName = lawcaseName;
	}
	public String getPersonClass() {
		return personClass;
	}
	public void setPersonClass(String personClass) {
		this.personClass = personClass;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCrimeTypeName() {
		return crimeTypeName;
	}

	public void setCrimeTypeName(String crimeTypeName) {
		this.crimeTypeName = crimeTypeName;
	}

	public Date getOdpsTime() {
		return odpsTime;
	}

	public void setOdpsTime(Date odpsTime) {
		this.odpsTime = odpsTime;
	}

	public int getPersonFlag() {
		return personFlag;
	}

	public void setPersonFlag(int personFlag) {
		this.personFlag = personFlag;
	}

	public int getHotelFlag() {
		return hotelFlag;
	}

	public void setHotelFlag(int hotelFlag) {
		this.hotelFlag = hotelFlag;
	}

	public int getFlightFlag() {
		return flightFlag;
	}

	public void setFlightFlag(int flightFlag) {
		this.flightFlag = flightFlag;
	}

	public int getTrainFlag() {
		return trainFlag;
	}

	public void setTrainFlag(int trainFlag) {
		this.trainFlag = trainFlag;
	}

	public int getInternetFlag() {
		return internetFlag;
	}

	public void setInternetFlag(int internetFlag) {
		this.internetFlag = internetFlag;
	}

	public int getMobileInfoFlag() {
		return mobileInfoFlag;
	}

	public void setMobileInfoFlag(int mobileInfoFlag) {
		this.mobileInfoFlag = mobileInfoFlag;
	}

	public int getDuoweiFlag() {
		return duoweiFlag;
	}

	public void setDuoweiFlag(int duoweiFlag) {
		this.duoweiFlag = duoweiFlag;
	}

	public int getHailiangFlag() {
		return hailiangFlag;
	}

	public void setHailiangFlag(int hailiangFlag) {
		this.hailiangFlag = hailiangFlag;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEscuage() {
		return escuage;
	}

	public void setEscuage(String escuage) {
		this.escuage = escuage;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getWork_trip() {
		return work_trip;
	}

	public void setWork_trip(String work_trip) {
		this.work_trip = work_trip;
	}

	public String getWork_time() {
		return work_time;
	}

	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTheft() {
		return theft;
	}

	public void setTheft(String theft) {
		this.theft = theft;
	}

	public String getPoison() {
		return poison;
	}

	public void setPoison(String poison) {
		this.poison = poison;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getImeiEsnMeid() {
		return imeiEsnMeid;
	}

	public void setImeiEsnMeid(String imeiEsnMeid) {
		this.imeiEsnMeid = imeiEsnMeid;
	}

	public String getBluetoothMac() {
		return bluetoothMac;
	}

	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}

	public String getModelResult() {
		return modelResult;
	}

	public void setModelResult(String modelResult) {
		this.modelResult = modelResult;
	}

	public String getBroadBand() {
		return broadBand;
	}

	public void setBroadBand(String broadBand) {
		this.broadBand = broadBand;
	}

	public String getCarryBankCard() {
		return carryBankCard;
	}

	public void setCarryBankCard(String carryBankCard) {
		this.carryBankCard = carryBankCard;
	}

	public String getFoothold() {
		return foothold;
	}

	public void setFoothold(String foothold) {
		this.foothold = foothold;
	}

	public String getLifeHobby() {
		return lifeHobby;
	}

	public void setLifeHobby(String lifeHobby) {
		this.lifeHobby = lifeHobby;
	}

	public String getConsumptiveHabit() {
		return consumptiveHabit;
	}

	public void setConsumptiveHabit(String consumptiveHabit) {
		this.consumptiveHabit = consumptiveHabit;
	}

	public String getMobileUsage() {
		return mobileUsage;
	}

	public void setMobileUsage(String mobileUsage) {
		this.mobileUsage = mobileUsage;
	}

	public String getNetworkBehavior() {
		return networkBehavior;
	}

	public void setNetworkBehavior(String networkBehavior) {
		this.networkBehavior = networkBehavior;
	}

	public String getCaseSpaceTime() {
		return caseSpaceTime;
	}

	public void setCaseSpaceTime(String caseSpaceTime) {
		this.caseSpaceTime = caseSpaceTime;
	}

	public String getMobileAndCaseRelation() {
		return mobileAndCaseRelation;
	}

	public void setMobileAndCaseRelation(String mobileAndCaseRelation) {
		this.mobileAndCaseRelation = mobileAndCaseRelation;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}

	public String getCrimeOperandi() {
		return crimeOperandi;
	}

	public void setCrimeOperandi(String crimeOperandi) {
		this.crimeOperandi = crimeOperandi;
	}

	public String getSelectTarget() {
		return selectTarget;
	}

	public void setSelectTarget(String selectTarget) {
		this.selectTarget = selectTarget;
	}

	public String getSelectTool() {
		return selectTool;
	}

	public void setSelectTool(String selectTool) {
		this.selectTool = selectTool;
	}

	public String getCrimeToolSource() {
		return crimeToolSource;
	}

	public void setCrimeToolSource(String crimeToolSource) {
		this.crimeToolSource = crimeToolSource;
	}

	public String getCrossRegion() {
		return crossRegion;
	}

	public void setCrossRegion(String crossRegion) {
		this.crossRegion = crossRegion;
	}

	public String getPartnerCase() {
		return partnerCase;
	}

	public void setPartnerCase(String partnerCase) {
		this.partnerCase = partnerCase;
	}

	public String getCommitInCrime() {
		return commitInCrime;
	}

	public void setCommitInCrime(String commitInCrime) {
		this.commitInCrime = commitInCrime;
	}

	public String getCant() {
		return cant;
	}

	public void setCant(String cant) {
		this.cant = cant;
	}

	public String getEscapeCode() {
		return escapeCode;
	}

	public void setEscapeCode(String escapeCode) {
		this.escapeCode = escapeCode;
	}

	public String getStayAfterCase() {
		return stayAfterCase;
	}

	public void setStayAfterCase(String stayAfterCase) {
		this.stayAfterCase = stayAfterCase;
	}

	public String getDisposalMode() {
		return disposalMode;
	}

	public void setDisposalMode(String disposalMode) {
		this.disposalMode = disposalMode;
	}

	public String getDisposalTime() {
		return disposalTime;
	}

	public void setDisposalTime(String disposalTime) {
		this.disposalTime = disposalTime;
	}

	public int getModelFlag() {
		return modelFlag;
	}

	public void setModelFlag(int modelFlag) {
		this.modelFlag = modelFlag;
	}

	public int getTxlFlag() {
		return txlFlag;
	}

	public void setTxlFlag(int txlFlag) {
		this.txlFlag = txlFlag;
	}

	public int getThjlFlag() {
		return thjlFlag;
	}

	public void setThjlFlag(int thjlFlag) {
		this.thjlFlag = thjlFlag;
	}

	public int getDxFlag() {
		return dxFlag;
	}

	public void setDxFlag(int dxFlag) {
		this.dxFlag = dxFlag;
	}

	public int getQqFlag() {
		return qqFlag;
	}

	public void setQqFlag(int qqFlag) {
		this.qqFlag = qqFlag;
	}

	public int getWxFlag() {
		return wxFlag;
	}

	public void setWxFlag(int wxFlag) {
		this.wxFlag = wxFlag;
	}

	public String getOrgStr() {
		return orgStr;
	}

	public void setOrgStr(String orgStr) {
		this.orgStr = orgStr;
	}

	public int getModelPoint() {
		return modelPoint;
	}

	public void setModelPoint(int modelPoint) {
		this.modelPoint = modelPoint;
	}

	public int getPackNum() {
		return packNum;
	}

	public void setPackNum(int packNum) {
		this.packNum = packNum;
	}

	public String getPackNameStr() {
		return packNameStr;
	}

	public void setPackNameStr(String packNameStr) {
		this.packNameStr = packNameStr;
	}

	public int getModelPointDrugs() {
		return modelPointDrugs;
	}

	public void setModelPointDrugs(int modelPointDrugs) {
		this.modelPointDrugs = modelPointDrugs;
	}

	public int getModelPointStael() {
		return modelPointStael;
	}

	public void setModelPointStael(int modelPointStael) {
		this.modelPointStael = modelPointStael;
	}
}
