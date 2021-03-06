package com.dearjing.mall.core.api.common.service;

import com.dearjing.mall.boot.utils.DateUtils;
import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.api.common.controller.form.SignupForm;
import com.dearjing.mall.core.common.entity.Customer;
import com.dearjing.mall.core.common.entity.User;
import com.dearjing.mall.core.common.mapper.CustomerMapper;
import com.dearjing.mall.core.common.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Random;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    Random r = new Random();
    @Autowired
    UserMapper userMapper;

    @Override
    public Object login(LoginForm form) throws Exception {
        User customer = userMapper.getByName(form.getUsername());
        if (ObjectUtils.isEmpty(customer)) {
            throw new Exception("该用户不存在");
        }
        return getUserToken(customer);
    }

    Object getUserToken(User user) {
        return (System.currentTimeMillis() - DateUtils.getYearFirst()) + "-" + user.getId() + "-" + Math.abs(r.nextInt()) + "-" + 365 * 24 + "";
    }

    @Override
    public Object signup(SignupForm form) throws Exception {
        User customer = userMapper.getByName(form.getUsername());
        if (!ObjectUtils.isEmpty(customer)) {
            throw new Exception("用户已经存在");
        }
        var newCustomer = new User();
        BeanUtils.copyProperties(form, newCustomer);
        userMapper.insertSelective(newCustomer);
        return "注册成功";
    }
}
