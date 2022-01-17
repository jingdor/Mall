package com.dearjing.mall.core.admin.common.api.form;

import com.dearjing.mall.core.common.controller.form.PageForm;
import com.dearjing.mall.core.common.entity.Order;
import lombok.Data;

@Data
public class OrderForm extends Order implements PageForm {
    Integer pageNum;
    Integer pageStart;
}
