package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.api.form.OrderForm;
import com.dearjing.mall.core.admin.common.service.AdminOrderService;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class AdminOrderApi {
    @Autowired
    AdminOrderService adminOrderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order/create")
    public ResDto<?> create(@RequestBody Order form) throws Exception {
        return new ResDto(adminOrderService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/order/save")
    public ResDto<?> save(@RequestBody Order form) throws Exception {
        return new ResDto(adminOrderService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/order/query")
    public ResDto<?> query(@RequestBody OrderForm form) throws Exception {
        return new ResDto(adminOrderService.query(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/order/delete")
    public ResDto<?> delete(@RequestBody Order form) throws Exception {
        return new ResDto(adminOrderService.delete(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/order/info")
    public ResDto<?> info(Order form) throws Exception {
        return new ResDto(adminOrderService.info(form));
    }
}
