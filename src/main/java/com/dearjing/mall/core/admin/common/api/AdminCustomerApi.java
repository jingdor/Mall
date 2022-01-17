package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.service.AdminCustomerService;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.Category;
import com.dearjing.mall.core.common.entity.Customer;
import com.dearjing.mall.core.common.service.CategoryService;
import com.dearjing.mall.core.common.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class AdminCustomerApi {
    @Autowired
    AdminCustomerService adminCustomerService;

    @RequestMapping(method = RequestMethod.POST, value = "/customer/create")
    public ResDto<?> create(@RequestBody Customer form) throws Exception {
        return new ResDto(adminCustomerService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/customer/save")
    public ResDto<?> save(@RequestBody Customer form) throws Exception {
        return new ResDto(adminCustomerService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/customer/query")
    public ResDto<?> query(@RequestBody Customer form) throws Exception {
        return new ResDto(adminCustomerService.query(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/customer/delete")
    public ResDto<?> delete(@RequestBody Customer form) throws Exception {
        return new ResDto(adminCustomerService.delete(form));
    }
}
