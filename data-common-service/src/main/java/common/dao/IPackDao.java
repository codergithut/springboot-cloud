package common.dao;

import com.domain.entity.Pack;

import java.util.List;
import java.util.Map;

/**
 * 检材
 * 
 * @author ll
 * 
 */
public interface IPackDao {

	List<Pack> getRecentPack();
	
	List<Pack> getRecentPackBySuspect(Map<String, Object> map);
	
	List<Integer> getSuspectByAccount(Integer accountId);

	
}
