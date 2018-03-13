package com.api.common;

import com.config.FullLogConfiguration;
import com.domain.entity.Lawcase;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "data-mongo",configuration = FullLogConfiguration.class, fallback = CommonDataServiceImpl.class)
public interface CommonDataService {

    @RequestMapping("/api/law")
    List<Lawcase> caseInfo(int countId);

    @RequestMapping("/api/sup")
    Map<String, Object> supInfo(int countId);

    @RequestMapping("/api/upload")
    List<Map<String, Object>> uploadInfo(int countId);
}
