package com.dearjing.mall.core.common.mapper;


import com.dearjing.mall.core.common.entity.Customer;
import com.dearjing.mall.core.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper  extends tk.mybatis.mapper.common.Mapper<User> {
    @Select("select * from user where name=#{name}")
    User getByName(String username);
}