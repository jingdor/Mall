package com.dearjing.mall.core.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class OrderItem extends Base{
    @Id
    @Column(insertable = false)
    @GeneratedValue(generator = "JDBC")
    Integer id;
    /**
     * 对应的订单号
     */
    String orderId;
    /**
     * 数量
     */
    Integer quantity;
    /**
     * 总价
     */
    Integer totalPrice;
    /**
     *快照id
     */
    Integer snapshotId;
}
