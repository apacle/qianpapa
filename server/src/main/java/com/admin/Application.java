package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@VueBootApplication
@MapperScan({"com.admin"})
public class Application {

    public static void main(String[] args) {
//        VueFramework.processApplicationArgs(Application.class, args);
        SpringApplication.run(Application.class, args);
    }
}
