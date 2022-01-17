package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.CategoryForm;
import com.dearjing.mall.core.common.entity.Category;

import java.util.List;

public interface AdminCategoryService {
    Category create(Category form);

    Category save(Category form);

    List<Category> query(CategoryForm form);

    Boolean delete(Category form);

    Object info(Category form);
}
