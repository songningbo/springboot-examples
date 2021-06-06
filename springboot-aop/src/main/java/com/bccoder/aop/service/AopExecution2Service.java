package com.bccoder.aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExecution2Service {

    @Pointcut(value = "execution(* com.bccoder.aop.controller.*.* (..))")
    public void testPointCut(){
        System.out.println("------------获取切点2-----------");
    }

    @Before("testPointCut()")
    public void beforeTest(){
        System.out.println("-----------调用接口2之前-------------");
    }

    @After("testPointCut()")
    public void afterTest(){
        System.out.println("-----------调用接口2之后--------------");
    }

    @Around("testPointCut()")
    public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("-----------调用接口2around-----------");
        return proceedingJoinPoint.proceed();
    }

    @AfterReturning(value = "testPointCut()",returning = "ret")
    public void afterReturningAdvice(String ret){
        System.out.println("----------调用接口2AfterReturning----"+ret);
    }

    @AfterThrowing(value = "testPointCut()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception){

        System.out.println("----------调用接口2抛出异常---------");
        if(exception instanceof Exception){
            System.out.println("---------捕获异常2成功------------"+exception.getMessage());
        }
    }
}
