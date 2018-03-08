package mongo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("mongo.dao")
public class MongdoService {
    public static void main(String[] args) {
        SpringApplication.run(MongdoService.class,args);
    }
}
