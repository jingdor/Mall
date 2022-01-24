package com.dearjing.mall.core.admin.common.service.impl;

import com.dearjing.mall.core.admin.common.api.form.ProductForm;
import com.dearjing.mall.core.admin.common.service.AdminProductService;
import com.dearjing.mall.core.common.entity.Product;
import com.dearjing.mall.core.common.entity.ProductSnapshot;
import com.dearjing.mall.core.common.mapper.ProductMapper;
import com.dearjing.mall.core.common.mapper.ProductSnapshotMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductSnapshotMapper productSnapshotMapper;

    @Override
    public Object create(Product form) {
        productMapper.insert(form);
        return form;
    }

    @Override
    public Object save(Product form) {
        productMapper.updateByPrimaryKey(form);
        return null;
    }

    @Override
    public  List<Product>  query(ProductForm form) {
        return productMapper.select(form);
    }

    @Override
    public Object delete(Product form) {
        return null;
    }

    @Override
    public Object info(Product form) {
        return productMapper.selectById(form.getId());
    }

    @Override
    public void publish(Product p) {
        var sn=new ProductSnapshot();
        var source=productMapper.selectById(p.getId());
        BeanUtils.copyProperties(source,sn,"id");
        sn.setProductId(source.getId());
        productSnapshotMapper.insert(sn);
    }

    @Override
    public void takedown(Product product) {
        productSnapshotMapper.tokedownByProduct(product);
    }

    @Override
    public void shelves(Product p1) {
        //上架 创建快照
        productSnapshotMapper.shelvesByProduct(p1);
    }

    @Override
    public List<Product> getByName(String name) {
        return productMapper.selectByName(name);
    }

    @Override
    public List<ProductSnapshot> getByProductHistory(Integer id) {
        return productSnapshotMapper.getByProductId(id);
    }
}
