package mongo.service.test.impl;

import mongo.dao.CityDao;
import com.domain.entity.City;
import mongo.service.test.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    /**
     * 查询city数据层
     */
    @Autowired
    private CityDao cityDao;

    /**
     *
     * @param cityName 获取特定名称的城市名称
     * @return 城市信息
     */
    public City findCityByName(String cityName) {
        System.out.println("mysql 测试：" + cityName);
        return cityDao.findByName(cityName);
    }

}