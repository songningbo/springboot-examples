package com.example.condition.annotation;

import com.example.condition.beans.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
    public TestClassCondition getClassCondition(TestBean bean){
        System.out.println("testClassCondition init......");
        TestClassCondition testClassCondition = new TestClassCondition(bean);
        return testClassCondition;
    }

    @Bean
    @ConditionalOnMissingBean(TestBean.class)
    public TestClassMissCondition getClassMissCondition(TestMissBean bean){
        System.out.println("testClassMissCondition init......");
        TestClassMissCondition testClassMissCondition = new TestClassMissCondition(bean);
        return testClassMissCondition;
    }


}
