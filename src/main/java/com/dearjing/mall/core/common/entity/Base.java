package com.dearjing.mall.core.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Base {
    Date createAt;
    Date updateAt;
    Date deleteAt;
    Integer createUserId;
    Integer updateUserId;
    Integer deleteUserId;
}
