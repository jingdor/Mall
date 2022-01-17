package com.dearjing.mall.core.common.mapper;


import com.dearjing.mall.core.common.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CustomerMapper extends tk.mybatis.mapper.common.Mapper<Customer> {

    @Select("select * from  customer where username=#{username} limit 1")
    Customer getByName(@Param("username") String username);
}