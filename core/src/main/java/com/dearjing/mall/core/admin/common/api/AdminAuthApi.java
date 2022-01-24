package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.service.AdminAuthService;
import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.api.common.controller.form.SignupForm;
import com.dearjing.mall.core.api.common.service.AuthService;
import com.dearjing.mall.core.common.dto.ResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@Slf4j
public class AdminAuthApi {

    @Autowired
    AdminAuthService adminAuthService;

    @RequestMapping(method = RequestMethod.POST, value = "/admin/login")
    public ResDto<?> login(@RequestBody LoginForm form) throws Exception {
        return new ResDto(adminAuthService.login(form));
    }
}
