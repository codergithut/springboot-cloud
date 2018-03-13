package common.dao;

public interface ISuspectDao {
	/**
	 * 查找嫌疑人创建单位
	 * @param suspectId
	 * @return
	 */
	String getOrganizationBySuspect(Integer suspectId);

	
	Integer getAllSuspectNumber();

}	
