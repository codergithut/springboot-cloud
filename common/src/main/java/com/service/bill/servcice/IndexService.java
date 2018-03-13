package com.service.bill.servcice;

import com.domain.entity.Lawcase;

import java.util.List;
import java.util.Map;


public interface IndexService {
	
	
	public Map<String, Object> getAllNumbers();
	
	public Map<String, Object> getIndex5Suspects(Integer accountId);
	
	public List<Lawcase> getIndexLawcaseList(Integer accountId);
	
	public List<Map<String,Object>> getUploadDataRecently();

	
}
