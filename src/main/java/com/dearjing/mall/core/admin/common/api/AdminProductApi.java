package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.service.AdminProductService;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.Product;
import com.dearjing.mall.core.common.service.ProductService;
import com.dearjing.mall.core.common.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class AdminProductApi {
    @Autowired
    AdminProductService adminProductService;

    @RequestMapping(method = RequestMethod.POST, value = "/product/create")
    public ResDto<?> create(@RequestBody Product form) throws Exception {
        return new ResDto(adminProductService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/product/save")
    public ResDto<?> save(@RequestBody Product form) throws Exception {
        return new ResDto(adminProductService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product/query")
    public ResDto<?> query(@RequestBody Product form) throws Exception {
        return new ResDto(adminProductService.query(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/product/delete")
    public ResDto<?> delete(@RequestBody Product form) throws Exception {
        return new ResDto(adminProductService.delete(form));
    }
}
