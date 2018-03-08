package mongo.controller.test;

import com.domain.entity.User;
import mongo.service.test.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;


@RestController
public class FeginRealService {

    @Autowired
    CityService cityService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String hello(@RequestParam String username){
        Integer eventNum = (int) mongoTemplate.count(new Query(), "event_collection");
        String restult = "我看到杭州的描述是 ：" +  cityService.findCityByName("杭州").getDescription() + "我还顺便mongo下数据找到数据为：" + eventNum;
        return restult;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String username, @RequestHeader Integer age){
        return new User(username,age);
    }

    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "hello "+user.getUsername() +", "+user.getAge()+", "+user.getId();
    }

}
