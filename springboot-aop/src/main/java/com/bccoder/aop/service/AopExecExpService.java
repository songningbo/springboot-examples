package com.bccoder.aop.service;

import com.bccoder.aop.entity.UserEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExecExpService {

    //1. execution表达式
    @Pointcut("execution(* com.bccoder.aop.controller.TestExecExpController.*(..))")
    public void testExec(){

    }
    @Before("testExec()")
    public void testExecShow(){
        System.out.println("----------within表达式--方法执行之前----------");
    }
    //2. within:匹配TestExecExpController类中所有方法
    @Pointcut("within(com.bccoder.aop.controller.TestExecExpController)")
    public void testWithin() {

    }
    //2. within:匹配com.bccoder.aop包及其子包所有类中的所有方法
    @Pointcut("within(com.bccoder.aop.*)")
    public void testWithin2(){

    }
    @Before("testWithin()||testWithin2()")
    public void testWithinShow(){
        System.out.println("----------within表达式--方法执行之前----------");
    }

    //3. this: 代理对象为指定的类型会被拦截
    @Before("this(com.bccoder.aop.service.ITestThisService)")
    public void thisInvoke(JoinPoint point){
        System.out.println("----------this表达式--方法执行之前----------");
    }
    //4. target：用于向通知方法传入目标对象的引用
    @Before("target(com.bccoder.aop.service.ITestThisService)")
    public void targetInvoke( ){
        System.out.println("----------target表达式--方法执行之前----------");
    }
    //5. args：用于将参数传入到通知方法中
    @Before("testExec()&&args(com.bccoder.aop.entity.UserEntity)")
    public void argsInvoke(JoinPoint joinpoint){
        System.out.println("----------args表达式--方法执行之前------------");
    }
    //6. @within:类型注解类名，假如目标类按类型匹配于某个类A，且类A标注了特定注解，则目标类的所有连接点匹配这个切点。
    @Pointcut("@within(com.bccoder.aop.annotation.AdviceWithin)")
    public void testWithinAnno(){

    }
    @Before("testWithinAnno()")
    public void testAnnoWithinShow(){
        System.out.println("----------@within表达式--方法执行之前------------");
    }
    //7. @Target：类型注解类名，目标类标注了特定注解，则目标类所有连接点匹配该切点。
    @Pointcut("@target(com.bccoder.aop.annotation.AdviceTarget)")
    public void testTarget(){

    }
    @Before("testExec()&&testTarget()")
    public void testTargetShow(){
        System.out.println("----------@target表达式--方法执行之前------------");
    }
    //8. @args：类型注解类名，通过判别目标方法的运行时入参对象的类是否标注特定注解来指定连接点。
    @Pointcut("@args(com.bccoder.aop.annotation.AdviceArgs)")
    public void testArgs(){

    }
    @Around("execution(* com.bccoder..*.*(..))&&testArgs()")
    public Object testArgsShow(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----------@args表达式--方法执行之前------------");
        return proceedingJoinPoint.proceed();
    }

    //9. @annotation:方法注解类名，表示标注了特定注解的目标方法连接点。
    @Pointcut("@annotation(com.bccoder.aop.annotation.AdviceAnno)")
    public void testAnno(){

    }
    @Before("testAnno()")
    public void testAnnoShow(){
        System.out.println("----------@annoation表达式--方法执行之前------------");
    }
    //10. bean：通过受管Bean的名字来限定连接点所在的Bean。
    @Pointcut("bean(testThisServiceImpl)")
    public void testBean(){

    }
    @Before("testBean()")
    public void testBeanShow(){
        System.out.println("----------bean表达式--方法执行之前------------");
    }
}
