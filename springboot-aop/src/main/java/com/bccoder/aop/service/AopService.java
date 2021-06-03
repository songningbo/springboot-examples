package com.bccoder.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义类为切面类
 */
@Aspect
@Component
public class AopService {

    @Pointcut(value = "execution(* com.bccoder.aop.* (..))")
    public void testPointCut(){

    }
}
