package com.dearjing.mall.core.api.common.service;

import com.dearjing.mall.boot.utils.MdUtils;
import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.api.common.controller.form.SignupForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@Slf4j
@Transactional
class AuthServiceImplTest {

    @Autowired
    AuthService authService;

    @Test
    void login() throws Exception {
        signup();
        log.info("测试用户登录");
        var form=new LoginForm();
        form.setUsername("test");
        form.setPassword(MdUtils.md5("test".getBytes()));
        var res=authService.login(form);
        log.info("token:"+res);
    }

    @Test
    void signup() throws Exception {
        log.info("测试用户注册");
        var form=new SignupForm();
        form.setUsername("test");
        form.setName("test");
        form.setPassword(MdUtils.md5("test".getBytes()));
        authService.signup(form);
    }
}