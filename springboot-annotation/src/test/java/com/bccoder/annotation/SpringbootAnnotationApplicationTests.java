package com.bccoder.annotation;

import com.bccoder.annotation.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringbootAnnotationApplicationTests {

    @Test
    void testComponentScanValue() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }
    @Test
    void testComponentScanDefaultValue() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserDefaultConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }
    @Test
    void testClasses() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserClassesConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }

    @Test
    void testUseDefaultFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserDefaultFilterConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }
    @Test
    void testIncludeAnnFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserIncludeAnnConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }

    @Test
    void testIncludeAssFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserAssTypeConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }

    @Test
    void testIncludeAspectFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserAspectjConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }

    @Test
    void testIncludeRegexFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserRegexConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }
    @Test
    void testIncludeCustomFilters() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserCustomConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if(name.contains("user")){
                System.out.println(name);
            }
        }
    }



}
