package com.bccoder.aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 定义类为切面类
 */
@Aspect
@Component
@Order(1)
public class AopExecutionService {

    @Pointcut(value = "execution(* com.bccoder.aop.controller.*.* (..))")
    public void testPointCut(){
    }

    @Pointcut(value = "execution(* com.bccoder.aop.controller.*.* (..))&&within(com.bccoder.aop.controller.*)&& args(userId)")
    public void testAutoGet(String userId){
        System.out.println("------------获取切点-----------");
    }

    @Before("testAutoGet(userId)")
    public void beforeTest2(String userId){
        System.out.println("-----------自动获取-------------"+userId);
    }


    @Before("testPointCut()")
    public void beforeTest(){
        System.out.println("-----------调用接口之前-------------");
    }

    @After("testPointCut()")
    public void afterTest(){
        System.out.println("-----------调用接口之后--------------");
    }

    @Around("testPointCut()")
    public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("-----------调用接口around-----------");
        return proceedingJoinPoint.proceed();
    }

    @AfterReturning(value = "testPointCut()",returning = "ret")
    public void afterReturningAdvice(String ret){
        System.out.println("----------调用接口AfterReturning----"+ret);
    }

    @AfterThrowing(value = "testPointCut()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable exception){

        System.out.println("----------调用接口抛出异常---------");
        if(exception instanceof Exception){
            System.out.println("---------捕获异常成功------------"+exception.getMessage());
        }
    }
}

