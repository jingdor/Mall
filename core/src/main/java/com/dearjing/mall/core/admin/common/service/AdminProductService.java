package com.dearjing.mall.core.admin.common.service;

import com.dearjing.mall.core.admin.common.api.form.ProductForm;
import com.dearjing.mall.core.common.entity.Product;
import com.dearjing.mall.core.common.entity.ProductSnapshot;

import java.util.List;

public interface AdminProductService {
    Object create(Product form);

    Object save(Product form);

    List<Product>  query(ProductForm form);

    Object delete(Product form);

    Object info(Product form);

    void publish(Product p1);

    void takedown(Product p1);

    void shelves(Product p1);

    List<Product> getByName(String name);

    List<ProductSnapshot>  getByProductHistory(Integer id);
}
