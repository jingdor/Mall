package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@Slf4j
class AdminProductServiceTest {

    @Autowired
    AdminProductService adminProductService;

    @Test
    void create() {
        log.info("测试创建产品");
        adminProductService.create(Product.builder().name("主程序").salePrice(10000).build());
        adminProductService.create(Product.builder().name("扩展1").salePrice(10000).build());
        adminProductService.create(Product.builder().name("扩展2").salePrice(10000).build());
        adminProductService.create(Product.builder().name("扩展3").salePrice(10000).build());

    }

    @Test
    void save() {
    }

    @Test
    void query() {
    }

    @Test
    void delete() {
    }
}