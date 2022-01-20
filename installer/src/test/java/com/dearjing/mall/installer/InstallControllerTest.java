package com.dearjing.mall.installer;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@Slf4j
@ActiveProfiles("test")
class InstallControllerTest {

    @Value("${app.datasource}")
    String datasource;

    @Value("${app.user}")
    String user;

    @Value("${app.password}")
    String password;

    @Test
    void index() {
        log.info(datasource);
        FluentConfiguration configuration = new FluentConfiguration();
        configuration.schemas("public");
        configuration.locations("db/migration");
        configuration.dataSource(datasource, user, password);

        Flyway flyway = new Flyway(configuration);
        //
        flyway.migrate();
    }
}