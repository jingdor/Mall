package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class ProductSnapshot extends Base {
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    Integer productId;
    String name;
    String description;
    Integer salePrice;
    Integer saleStatus;
}
