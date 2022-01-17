package com.dearjing.mall.core.api.common.service;

import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.api.common.controller.form.SignupForm;

public interface AuthService {
    Object login(LoginForm form) throws Exception;

    Object signup(SignupForm form) throws Exception;
}
