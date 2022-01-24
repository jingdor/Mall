package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.ProductForm;
import com.dearjing.mall.core.common.entity.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@Slf4j
@Transactional
class AdminProductServiceTest {

    @Autowired
    AdminProductService adminProductService;

    @Test
    public void create() {
        log.info("测试创建产品");
        var p1=Product.builder().name("测试商品").salePrice(10000).build();
        adminProductService.create(p1);
        log.info("发布");
        adminProductService.publish(p1);
        adminProductService.shelves(p1);
        adminProductService.takedown(p1);
    }

    @Test
    void save() {
        log.info("修改商品信息");
        create();
        var pList=adminProductService.getByName("测试商品");
        Assertions.assertEquals(pList.size(),1);
        var p1=pList.get(0);
        adminProductService.shelves(p1);
        adminProductService.takedown(p1);

        p1.setName("测试商品2");
        adminProductService.save(p1);
        adminProductService.publish(p1);
        adminProductService.shelves(p1);
        var snList=adminProductService.getByProductHistory(p1.getId());
        Assertions.assertEquals(snList.size(),2);
    }

    @Test
    void query() {
        create();
        var f=new ProductForm();
        f.setPageNum(0);
        f.setPageSize(10);
        PageHelper.startPage(f.getPageNum(), f.getPageSize());
        var list=adminProductService.query(f);
        PageInfo p= new PageInfo<>(list);
        Assertions.assertEquals(p.getTotal(),1L);

    }

    @Test
    void delete() {
    }
}