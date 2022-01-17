package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.common.entity.Category;

public interface AdminCategoryService {
    Category create(Category form);

    Category save(Category form);

    Category query(Category form);

    Boolean delete(Category form);
}
