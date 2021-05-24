package com.bccoder.condition.annotation;

import com.bccoder.condition.beans.*;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean("testBean")
    public TestBean getBean(){
        System.out.println("testBean init......");
        TestBean bean = new TestBean();
        bean.setName("test bean");
        bean.setConditionalOnBean("conditonalOnBean");
        return bean;
    }
    @Bean
    public MyService getMyService(TestBean bean){
        System.out.println("myService init......");
        return new MyService(bean);
    }

    @Bean
    public TestMissBean getTestMissBean(){
        System.out.println("testMissBean init......");
        TestMissBean bean = new TestMissBean();
        bean.setConditionalOnMissBean("test conditional on miss bean");
        return bean;
    }

    @Bean
    @ConditionalOnBean(TestBean.class)
    public TestConditionBean getClassCondition(TestBean bean){
        System.out.println("testClassCondition init......");
        TestConditionBean testClassCondition = new TestConditionBean(bean);
        return testClassCondition;
    }

    @Bean
    @ConditionalOnMissingBean(TestBean.class)
    public TestConditionMissBean getClassMissCondition(TestMissBean bean){
        System.out.println("testClassMissCondition init......");
        TestConditionMissBean testClassMissCondition = new TestConditionMissBean(bean);
        return testClassMissCondition;
    }
    @Bean
    @ConditionalOnClass(TestBean.class)
    public TestConditionClass getConditionClass(){
        System.out.println("testConditionClass init......");
        TestConditionClass testConditionClass = new TestConditionClass();
        return testConditionClass;
    }
    @Bean
    @ConditionalOnClass(name="com.bccoder.condition.beans.TestBean")
    public TestConditionClass getConditionClass2(){
        System.out.println("testConditionClass2 init......");
        TestConditionClass testConditionClass = new TestConditionClass();
        return testConditionClass;
    }
    @Bean
    @ConditionalOnMissingClass("com.bccoder.condition.beans.TestBean")
    public TestConditionMissClass getConditionMissClass(){
        System.out.println("testConditionMissClass init......");
        TestConditionMissClass testConditionMissClass = new TestConditionMissClass();
        return testConditionMissClass;
    }
    @Bean
    @ConditionalOnMissingClass("com.bccoder.condition.beans.TestBean1")
    public TestConditionMissClass getConditionMissClass2(){
        System.out.println("testConditionMissClass2 init......");
        TestConditionMissClass testConditionMissClass = new TestConditionMissClass();
        return testConditionMissClass;
    }
}
