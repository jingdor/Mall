package com.dearjing.mall.installer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@EnableWebMvc
public class InstallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstallerApplication.class, args);
    }
}
