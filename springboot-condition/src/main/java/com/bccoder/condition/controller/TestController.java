package com.bccoder.condition.controller;

import com.bccoder.condition.beans.MyService;
import com.bccoder.condition.beans.TestConditionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MyService myService;

    @Autowired
    private TestConditionBean testClassCondition;


    @GetMapping("testConfig")
    public String getBean(){
        return myService.getName();
    }

    @GetMapping("conditionalOnBean")
    public String testClassCondition(){
        return testClassCondition.getName();
    }
}
