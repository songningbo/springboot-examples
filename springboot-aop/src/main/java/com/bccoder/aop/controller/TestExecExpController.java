package com.bccoder.aop.controller;

import com.bccoder.aop.annotation.AdviceAnno;
import com.bccoder.aop.annotation.AdviceArgs;
import com.bccoder.aop.annotation.AdviceTarget;
import com.bccoder.aop.annotation.AdviceWithin;
import com.bccoder.aop.entity.UserEntity;
import com.bccoder.aop.service.ITestThisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AdviceWithin
@AdviceTarget
public class TestExecExpController {
    @Autowired
    ITestThisService iTestThisService;

    @GetMapping("testExpress/{id}")
    @ResponseBody
    public String testExpress(@PathVariable("id")String id) throws Exception {
        System.out.println("-----------调用接口ing-------------");
        return "success";
    }
    @GetMapping("testExpress1/{id}")
    @ResponseBody
    @AdviceAnno
    public String testExpress1(@PathVariable("id")String id) throws Exception {

        return iTestThisService.m1();
    }
    @GetMapping("testExpress2/{id}")
    @ResponseBody
    @AdviceAnno
    public String testExpress2(UserEntity userEntity) throws Exception {
            userEntity.setName("success invoke");
        return userEntity.getName();
    }

}
