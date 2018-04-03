package common.dao;

import com.domain.entity.Lawcase;

import java.util.List;
import java.util.Map;

/**
 * 案件
 * 
 * @author ll
 * 
 */
public interface ICaseDao {
	
	Integer getAllLawcaseNumber();
	
	List<Lawcase> getIndexLawcaseList(Map<String, Object> map);

	List<Integer> getCaseTypeByDeviceId(String pack_id);


}
