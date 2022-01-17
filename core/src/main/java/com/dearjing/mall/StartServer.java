package com.dearjing.mall;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@MapperScan("com.dearjing.mall.core.admin.*.mapper," +
        "com.dearjing.mall.core.api.*.mapper," +
        "com.dearjing.mall.core.common.*.mapper")
@EnableScheduling
@EnableTransactionManagement
@EnableWebMvc
public class StartServer {

    public static void main(String[] args) {
        SpringApplication.run(StartServer.class, args);
    }

}
