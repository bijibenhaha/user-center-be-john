package com.john.usercenterbejohn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.john.usercenterbejohn.demos.web.mapper")
public class UserCenterBeJohnApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterBeJohnApplication.class, args);
    }

}
