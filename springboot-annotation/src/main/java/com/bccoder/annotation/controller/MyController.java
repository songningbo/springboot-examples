package com.bccoder.annotation.controller;

import com.bccoder.annotation.beans.ScopeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class MyController {

    @Autowired
    ScopeEntity twoScope;

    @GetMapping("/testBean")
    public String testBean2(){
        System.out.println(createScopeEntity());
        return "Success";
    }
    @Lookup("twoScope")
    public abstract ScopeEntity createScopeEntity();

    @GetMapping("/testBean1")
    public String testBean1(){
        System.out.println(twoScope);
        return "Success";
    }
}
