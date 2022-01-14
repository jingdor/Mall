package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class User extends Base {
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    /**
     * 用户名称
     */
    String name;
    /**
     * 用户名
     */
    String username;
    /**
     * 用户登录密码
     */
    String password;
}
