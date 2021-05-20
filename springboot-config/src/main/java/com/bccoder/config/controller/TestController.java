package com.bccoder.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class TestController {

//    @Value("${test}")
//    private String test;

    @Value("${test.config.name}")
    private String name;

//    @GetMapping("test")
//    public String showConfigPath(){
//        return test;
//    }
    @GetMapping("name")
    public String showConfigName(){
        return name;
    }
}
