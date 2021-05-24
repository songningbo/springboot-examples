package com.example.condition.controller;

import com.example.condition.beans.MyService;
import com.example.condition.beans.TestClassCondition;
import com.example.condition.beans.TestClassMissCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MyService myService;

    @Autowired
    private TestClassCondition testClassCondition;


    @GetMapping("testConfig")
    public String getBean(){
        return myService.getName();
    }

    @GetMapping("conditionalOnBean")
    public String testClassCondition(){
        return testClassCondition.getName();
    }
}
