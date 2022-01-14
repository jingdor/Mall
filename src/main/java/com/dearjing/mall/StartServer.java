package com.dearjing.mall;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@MapperScan("org.wh.wpm.core.admin.*.mapper,org.wh.wpm.core.api.*.mapper,org.wh.wpm.core.common.*.mapper")
@EnableScheduling
@EnableTransactionManagement
@EnableWebMvc
public class StartServer {

    public static void main(String[] args) {
        SpringApplication.run(StartServer.class, args);
    }

}
