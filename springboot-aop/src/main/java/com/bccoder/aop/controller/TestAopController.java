package com.bccoder.aop.controller;

import com.bccoder.aop.annotation.AdviceTarget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAopController {

    @GetMapping("testExecution/{id}")
    @ResponseBody
    public String testExecution(@PathVariable("id")String id) throws Exception {
        System.out.println("-----------调用接口ing-------------");
        if(id.equals("1")){
            throw new Exception("test exception");
        }
        return "success";
    }
}
