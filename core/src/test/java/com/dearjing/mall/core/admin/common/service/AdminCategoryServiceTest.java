package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.Category;
import com.dearjing.mall.core.common.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
@ActiveProfiles("test")
class AdminCategoryServiceTest {

    @Autowired
    AdminCategoryService categoryService;

    @Test
    void create() {
        var s=new Category();
        s.setName("测试");
        s.setPid(0);
        categoryService.create(s);
    }

    @Test
    void save() {

    }

    @Test
    void query() {
    }

    @Test
    void delete() {
        var s=new Category();
        s.setId(2);
        categoryService.delete(s);
    }
}