package com.dearjing.mall.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dearjing.mall.core.common.dto.ResDto;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResDto<Object> handlerException(Exception ex) {
        log.info("异常");
        ex.printStackTrace();
        return new ResDto<>(-1, ex.getMessage(), "");
    }
}
