package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Category  extends Base{
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    /**
     * 分类名称
     */
    String name;
    /**
     * 描述信息
     */
    String description;
    /**
     * 父id
     */
    Integer pid;
}
