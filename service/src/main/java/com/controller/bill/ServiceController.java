package com.controller.bill;

import com.api.mongo.FeinService;
import com.domain.entity.User;
import com.service.GetHotWorldImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class ServiceController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FeinService feinService;

    @Autowired
    GetHotWorldImpl getHotWorld;

    @RequestMapping(value = "/feign",method = RequestMethod.GET)
    public User hello2(@RequestParam String username, @RequestParam Integer age){
        logger.info(age.getClass().getName());
        return feinService.testFeginBean(username,age);
    }

    @RequestMapping(value = "/feign1",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return feinService.testFeginBean1(user);
    }

    @RequestMapping(value = "/feign2",method = RequestMethod.GET)
    public String hello4(@RequestParam String username){
        return feinService.testFegin(username);
    }

    @RequestMapping(value = "elasticsearch", method = RequestMethod.GET)
    public Object elasticSearch() {
        return getHotWorld.getHotWorld(null);
    }




}
