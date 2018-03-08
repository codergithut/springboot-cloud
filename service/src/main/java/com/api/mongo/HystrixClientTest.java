package com.api.mongo;

import com.domain.entity.User;
import org.springframework.stereotype.Component;

/**
 * 如果服务不可以用将使用改实现去忽悠用户
 */
@Component
public class HystrixClientTest implements FeinService {

    @Override
    public String testFegin(String username) {
        return "如果服务不阔以用就代表服务挂了";
    }

    @Override
    public User testFeginBean(String username, Integer age) {
        return null;
    }

    @Override
    public String testFeginBean1(User user) {
        return "如果服务不阔以用就代表服务挂了";
    }
}
