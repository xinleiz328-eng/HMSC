package com.hmall.user;

import com.hmall.api.client.ItemClient;
import com.hmall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.hmall.user.mapper")
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.hmall.api.client"}, clients = {ItemClient.class}, defaultConfiguration = DefaultFeignConfig.class)
public class userApplication {
    public static void main(String[] args) {
        SpringApplication.run(userApplication.class, args);
    }

}