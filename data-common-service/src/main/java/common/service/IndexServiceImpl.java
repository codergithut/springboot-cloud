package common.service;

import com.domain.entity.Lawcase;
import com.domain.entity.Pack;
import com.domain.entity.Suspect;
import com.service.bill.servcice.IndexService;
import common.dao.ICaseDao;
import common.dao.IPackDao;
import common.dao.ISuspectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RestController
public class IndexServiceImpl implements IndexService {

	@Autowired
	private ICaseDao caseDao;
	@Autowired
	private ISuspectDao suspectDao;
	@Autowired
	private IPackDao packDao;
	
	@Override
	@RequestMapping("/api/common")
	@ResponseBody
	public Map<String, Object> getAllNumbers() {
		Map<String, Object> result = new HashMap<>();
		Integer lawcaseNum = caseDao.getAllLawcaseNumber();
		Integer suspectNumber = suspectDao.getAllSuspectNumber();
		result.put("lawcaseNum", parseNumber("###,###", lawcaseNum) );
		result.put("suspectNumber", parseNumber("###,###", suspectNumber));
 		return result;
	}

	@Override
	@RequestMapping("/api/sup")
	@ResponseBody
	public Map<String, Object> getIndex5Suspects(Integer accountId) {
        accountId = 327;
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		
		List<Integer> suspectIds = packDao.getSuspectByAccount(327);
		
		Map<String, Object> param = new HashMap<>();
		param.put("limit", 30);
		param.put("suspectIds", suspectIds);
		List<Pack> packList =packDao.getRecentPackBySuspect(param);

		for(Pack pack:packList){
			Map<String, Object> suspectMap = new HashMap<>();
			Suspect suspect = new Suspect();
			suspect.setId(pack.getSuspectId());
			suspect.setName(pack.getPackName()==null?"&nbsp;":pack.getPackName());
			String orgName="";
			if(pack.getSuspectId() != null){
				orgName= suspectDao.getOrganizationBySuspect(pack.getSuspectId());
				suspect.setOrgStr(orgName==null?"":orgName);
			}
			suspect.setCreateTime(pack.getPackUploadTime());
			suspectMap.put("suspect", suspect);
			
			suspectMap.put("packNo",pack.getPackNo());
			suspectMap.put("manufacturer", pack.getManufacturer());
			suspectMap.put("model",pack.getModel());
			list.add(suspectMap);
		}
		
		if(list.size()>=1){
			result.put("suspectList1",list.subList(0, list.size()>5?5:list.size()));
		}
		if(list.size()>5 ){
			result.put("suspectList2",list.subList(5, list.size()>10?10:list.size()));
		}
		if(list.size()>10){
			result.put("suspectList3",list.subList(10, list.size()>15?15:list.size()));
		}
		if(list.size()>15 ){
			result.put("suspectList4",list.subList(15, list.size()>20?20:list.size()));
		}
		if(list.size()>20){
			result.put("suspectList5",list.subList(20, list.size()>25?25:list.size()));
		}
		if(list.size()>25){
			result.put("suspectList6",list.subList(25, list.size()>30?30:list.size()));
		}
		return result;
	}


	@Override
	@RequestMapping("/api/law")
	@ResponseBody
	public List<Lawcase> getIndexLawcaseList(Integer accountId) {
        accountId = 327;
		Map<String, Object> param = new HashMap<>();
		param.put("limit", 8);
		param.put("accountId", accountId);
		List<Lawcase> lawcaseList = caseDao.getIndexLawcaseList(param);
		return lawcaseList;
	}


    /**
     * 获取统计列表
     * @return
     */
	@Override
	@RequestMapping("/api/upload")
	@ResponseBody
	public List<Map<String, Object>> getUploadDataRecently() {
		
		List<Map<String, Object>> result = new ArrayList<>();
		
		List<String> dayList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance(); 
		 
		Map<String, Object> param = new HashMap<>();
		param.put("orgId", 1);
		
		param.put("dayList", dayList);
		
		List<Pack> packList = packDao.getRecentPack();
		
		Map<String, Object> packCountMap = new HashMap<>();
		for (Pack pack : packList) {
			packCountMap.put(pack.getPackName(), pack.getPackId());
		}
		
		for(int i = 6 ;i >=0;i--){
			Date day = new Date(); 
			calendar.setTime(day);
			Map<String, Object>  subResult = new HashMap<>();
	        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);  
	       
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        String dayStr = format.format(calendar.getTime()); 
	       
	        if(packCountMap.get(dayStr)==null){
	        	subResult.put("a", 0);
	        }else{
	        	subResult.put("a", packCountMap.get(dayStr));
	        }
	        subResult.put("y", dayStr);
			
	        result.add(subResult);
		}
		return result;
	}


	public String parseNumber(String pattern, Integer bd) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(bd);
	}
	
	
}
