package com.dearjing.mall.boot.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;


@Aspect
@Slf4j
@Configuration
public class ApiRequestTimeAop {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Around("execution(* com.dearjing.mall.core.admin.common.api..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object ret=joinPoint.proceed();
        Long timeTaken = System.currentTimeMillis() - startTime;
        log.info("API:{} EP: {} GAP: {}", httpServletRequest.getRequestURL().toString() ,joinPoint , timeTaken);
        return ret;
    }

}
