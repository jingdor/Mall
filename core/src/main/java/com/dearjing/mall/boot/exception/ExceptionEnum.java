package com.dearjing.mall.boot.exception;


import lombok.Getter;

@Getter
public enum ExceptionEnum implements IExceptionEnum{
    /*未知异常*/
    SYSTEM_ERROR(-1,"未知异常"),
    ;
   
    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
    
}
