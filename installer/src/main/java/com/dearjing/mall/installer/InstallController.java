package com.dearjing.mall.installer;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class InstallController {
    @RequestMapping(method = RequestMethod.GET, value = "/install")
    public String index() {
        Flyway flyway = Flyway.configure().locations("db/migration").dataSource("jdbc:postgresql://localhost:5432/test", "postgres", "123456").load();
        flyway.migrate();
        return "success";
    }
}
