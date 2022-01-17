package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.User;

public interface AdminUserService {
    Object create(User form);

    Object save(User form);

    Object query(User form);

    Object delete(User form);
}
