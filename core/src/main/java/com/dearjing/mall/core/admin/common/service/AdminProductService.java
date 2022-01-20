package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.ProductForm;
import com.dearjing.mall.core.common.entity.Product;

public interface AdminProductService {
    Object create(Product form);

    Object save(Product form);

    Object query(ProductForm form);

    Object delete(Product form);

    Object info(Product form);
}
