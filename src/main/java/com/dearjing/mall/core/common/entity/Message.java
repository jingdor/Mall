package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Message {
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    /**
     * 用户id
     */
    String userId;
    /**
     * 用户名
     */
    String payload;
    /**
     * 已读
     */
    Boolean read;

    /**
     * 创建时间
     */
    Date createAt;
}
