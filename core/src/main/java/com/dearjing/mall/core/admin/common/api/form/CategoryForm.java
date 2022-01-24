package com.dearjing.mall.core.admin.common.api.form;

import com.dearjing.mall.core.common.controller.form.PageForm;
import com.dearjing.mall.core.common.entity.Category;
import lombok.Data;

@Data
public class CategoryForm extends Category implements PageForm {
    Integer pageNum;
    Integer pageSize;
}
