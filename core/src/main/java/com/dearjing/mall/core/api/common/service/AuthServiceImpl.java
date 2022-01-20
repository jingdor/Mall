package com.dearjing.mall.core.api.common.service;

import com.dearjing.mall.boot.utils.DateUtils;
import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.api.common.controller.form.SignupForm;
import com.dearjing.mall.core.common.entity.Customer;
import com.dearjing.mall.core.common.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Random;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    Random r=new Random();
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Object login(LoginForm form) throws Exception {
        Customer customer= customerMapper.getByName(form.getUsername());
        if(ObjectUtils.isEmpty(customer)){
            throw new Exception("该用户不存在");
        }
        return getUserToken(customer);
    }

    Object getUserToken(Customer customer){
        return (System.currentTimeMillis()-DateUtils.getYearFirst()) +"-"+customer.getId()+"-"+Math.abs(r.nextInt())+"-"+365*24+"";
    }

    @Override
    public Object signup(SignupForm form) throws Exception {
        Customer customer= customerMapper.getByName(form.getUsername());
        if(!ObjectUtils.isEmpty(customer)){
            throw new Exception("用户已经存在");
        }
        var newCustomer=new Customer();
        BeanUtils.copyProperties(form,newCustomer);
        customerMapper.insertSelective(newCustomer);
        return "注册成功";
    }
}
