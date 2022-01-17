package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.service.AdminCategoryService;
import com.dearjing.mall.core.api.common.controller.form.LoginForm;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.Category;
import com.dearjing.mall.core.common.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class AdminCategoryApi {
    @Autowired
    AdminCategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/category/create")
    public ResDto<?> create(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/category/save")
    public ResDto<?> save(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/category/query")
    public ResDto<?> query(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.query(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/category/delete")
    public ResDto<?> delete(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.delete(form));
    }
}
