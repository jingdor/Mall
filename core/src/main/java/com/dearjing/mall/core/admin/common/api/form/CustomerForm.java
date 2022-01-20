package com.dearjing.mall.core.admin.common.api.form;

import com.dearjing.mall.core.common.controller.form.PageForm;
import com.dearjing.mall.core.common.entity.Customer;
import lombok.Data;

@Data
public class CustomerForm extends Customer implements PageForm {
    Integer pageNum;
    Integer pageStart;
}
