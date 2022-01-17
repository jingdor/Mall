package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.UserForm;
import com.dearjing.mall.core.common.entity.User;

public interface AdminUserService {
    Object create(User form);

    Object save(User form);

    Object query(UserForm form);

    Object delete(User form);

    Object info(User form);
}
