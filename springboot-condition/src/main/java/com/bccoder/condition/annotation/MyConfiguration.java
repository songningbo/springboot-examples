package com.bccoder.condition.annotation;

import com.bccoder.condition.beans.*;
import com.bccoder.condition.condition.CustomCondition;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
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
    @Bean
    @ConditionalOnProperty(name = "test.env.name")
    public TestConditionalOnProperty getConditionOnProperty(){
        System.out.println("testConditionalOnPropertyName init......");
        return new TestConditionalOnProperty();
    }
    @Bean
    @ConditionalOnProperty(name = "test.env.having.value",havingValue = "2")
    public TestConditionalOnProperty getConditionOnPropertyHavingValue(){
        System.out.println("testConditionalOnPropertyHavingValue init......");
        return new TestConditionalOnProperty();
    }
    @Bean
    @ConditionalOnProperty(name = "test.env.having.value",matchIfMissing = true)
    public TestConditionalOnProperty getConditionOnPropertyMatch(){
        System.out.println("testConditionalOnPropertyMatch init......");
        return new TestConditionalOnProperty();
    }
    @Bean
    @ConditionalOnExpression(value ="${test.expression}")
    public TestConditionalExpression getConditionExpression(){
        System.out.println("testConditionalExpression init......");
        return new TestConditionalExpression();
    }

    @Bean
    @ConditionalOnJava(range = ConditionalOnJava.Range.EQUAL_OR_NEWER,value = JavaVersion.EIGHT)
    public TestConditionalOnJava getConditionJava(){
        System.out.println("testConditionalJava init......");
        return new TestConditionalOnJava();
    }

    @Bean
    @ConditionalOnMissingBean(TestMultiConditional.class)
    @ConditionalOnJava(range = ConditionalOnJava.Range.EQUAL_OR_NEWER,value = JavaVersion.EIGHT)
    public TestMultiConditional getMultiConditional(){
        System.out.println("testMultiConditional init......");
        return new TestMultiConditional();
    }
    @Bean
    @Conditional(CustomCondition.class)
    public TestCustomCondition getCustomConditional(){
        System.out.println("testCustomCondition init......");
        return new TestCustomCondition();
    }
}
