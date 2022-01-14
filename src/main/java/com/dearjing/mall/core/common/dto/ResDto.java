package com.dearjing.mall.core.common.dto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    int code=-1;
    String msg="";
    T Data;
    public ResDto() {
        this.code=0;
        this.setData(null);
        this.msg="操作成功";
    }

    public ResDto(int code,String msg,T res) {
        this.Data=res;
        this.code=code;
        this.msg=msg;
    }

    public ResDto(T res) {
        this.Data=res;
        this.code=0;
        this.msg="";
    }

}