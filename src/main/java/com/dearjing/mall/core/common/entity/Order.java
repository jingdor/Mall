package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Order extends Base {
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    /**
     * 订单的号码
     */
    String orderId;
    /**
     * 购买的总价格
     */
    Integer totalPrice;
    /**
     * 购买的总数量
     */
    Integer totalAmount;
    /**
     * 狗买订单的用户
     */
    String customerId;
}
