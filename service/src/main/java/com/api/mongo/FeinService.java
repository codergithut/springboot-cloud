package com.api.mongo;

import com.config.FullLogConfiguration;
import com.domain.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/21
 * @since 1.0
 *
 *
 */
@FeignClient(value = "data-mongo",configuration = FullLogConfiguration.class, fallback = HystrixClientTest.class)
public interface FeinService {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    String testFegin(@RequestParam("username") String username);

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    User testFeginBean(@RequestHeader("username") String username, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    String testFeginBean1(@RequestBody User user);

}
