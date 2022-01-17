package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.Customer;

public interface AdminCustomerService {
    Object create(Customer form);

    Object save(Customer form);

    Object query(Customer form);

    Object delete(Customer form);

}
