package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.CustomerForm;
import com.dearjing.mall.core.common.entity.Customer;

public interface AdminCustomerService {
    Object create(Customer form);

    Object save(Customer form);

    Object query(CustomerForm form);

    Object delete(Customer form);

    Object info(Customer form);
}
