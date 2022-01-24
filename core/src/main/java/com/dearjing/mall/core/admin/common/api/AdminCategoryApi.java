package com.dearjing.mall.core.admin.common.api;

import com.dearjing.mall.core.admin.common.api.form.CategoryForm;
import com.dearjing.mall.core.admin.common.service.AdminCategoryService;
import com.dearjing.mall.core.common.dto.ResDto;
import com.dearjing.mall.core.common.entity.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    @Autowired
//    private Enforcer enforcer;

    @RequestMapping(method = RequestMethod.GET, value = "/category/info")
    public ResDto<?> info(Category form) throws Exception {


//        enforcer.addRoleForUser("测试用户A","测试角色A");
//        enforcer.addRoleForUser("测试用户B","测试角色A");
//        enforcer.addPermissionForUser("测试用户A","测试权限A");
//        enforcer.addPermissionForUser("测试用户B","测试权限B");
//
//        var r= enforcer.getAllRoles();
//        log.info("角色"+r);
//        var s= enforcer.getUsersForRole("测试角色A");
//        log.info("用户"+s);
//        var p= enforcer.getPermissionsForUser("测试用户A");
//        log.info("权限"+p);

        return new ResDto(categoryService.info(form));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category/create")
    public ResDto<?> create(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.create(form));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/category/save")
    public ResDto<?> save(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.save(form));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/category/query")
    public ResDto<?> query(@RequestBody CategoryForm form) throws Exception {
        PageHelper.startPage(form.getPageNum(), form.getPageSize());
        PageInfo<Category> pageInfo = new PageInfo<>(categoryService.query(form));
        return new ResDto(pageInfo);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/category/delete")
    public ResDto<?> delete(@RequestBody Category form) throws Exception {
        return new ResDto(categoryService.delete(form));
    }
}
