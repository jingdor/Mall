package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.api.form.UserForm;
import com.dearjing.mall.core.admin.common.service.AdminUserService;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class AdminUserApi {
    @Autowired
    AdminUserService adminUserService;

    @RequestMapping(method = RequestMethod.POST, value = "/user/create")
    public ResDto<?> create(@RequestBody User form) throws Exception {
        return new ResDto(adminUserService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/user/save")
    public ResDto<?> save(@RequestBody User form) throws Exception {
        return new ResDto(adminUserService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/query")
    public ResDto<?> query(@RequestBody UserForm form) throws Exception {
        return new ResDto(adminUserService.query(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/user/delete")
    public ResDto<?> delete(@RequestBody User form) throws Exception {
        return new ResDto(adminUserService.delete(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/info")
    public ResDto<?> info(User form) throws Exception {
        return new ResDto(adminUserService.info(form));
    }
}
