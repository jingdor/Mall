package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.Order;

public interface AdminOrderService {
    Object create(Order form);

    Object save(Order form);

    Object query(Order form);

    Object delete(Order form);
}
