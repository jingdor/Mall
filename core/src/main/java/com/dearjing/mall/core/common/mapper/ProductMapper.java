package com.dearjing.mall.core.common.mapper;


import com.dearjing.mall.core.common.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductMapper extends tk.mybatis.mapper.common.Mapper<Product> {

    @Select("select * from product where name=#{name}")
    List<Product> selectByName(@Param("name") String name);
    @Select("select * from product where id=#{id}")
    Product selectById(@Param("id") Integer id);
}