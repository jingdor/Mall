package com.dearjing.mall.core.common.mapper;


import com.dearjing.mall.core.common.entity.Product;
import com.dearjing.mall.core.common.entity.ProductSnapshot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ProductSnapshotMapper extends tk.mybatis.mapper.common.Mapper<ProductSnapshot> {


    @Update("update product_snapshot set sale_status=0 where product_id=#{form.id}")
    void shelvesByProduct(@Param("form") Product product);

    @Update("update product_snapshot set sale_status=1 where product_id=#{form.id}")
    void tokedownByProduct(@Param("form") Product product);

    @Select("select * from product_snapshot where product_id=#{id}")
    List<ProductSnapshot> getByProductId(@Param("id")Integer id);
}