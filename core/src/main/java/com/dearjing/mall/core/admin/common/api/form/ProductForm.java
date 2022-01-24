package com.dearjing.mall.core.admin.common.api.form;

import com.dearjing.mall.core.common.controller.form.PageForm;
import com.dearjing.mall.core.common.entity.Product;
import lombok.Data;

@Data
public class ProductForm extends Product implements PageForm {
    Integer pageNum;
    Integer pageSize;
}
